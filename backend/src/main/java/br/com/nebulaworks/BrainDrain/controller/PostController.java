package src.main.java.br.com.nebulaworks.BrainDrain.controller;

import br.com.nebulaworks.BrainDrain.model.Post;
import br.com.nebulaworks.BrainDrain.service.NotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {

    private final NotionService notionService;

    public PostController(NotionService notionService) {
        this.notionService = notionService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return NotionService.getPost();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id) {
        return NotionService.getPostById(id);
    }
}
