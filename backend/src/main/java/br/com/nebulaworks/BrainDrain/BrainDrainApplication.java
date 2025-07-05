package src.main.java.br.com.nebulaworks.BrainDrain;

import br.com.nebulaworks.BrainDrain.model.Post;
import br.com.nebulaworks.BrainDrain.service.NotionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BrainDrainApplication {
	public static void main(String[] args) {
		SpringApplication.run(BrainDrainApplication.class, args);

		NotionService service = new NotionService();

		List<Post> posts = service.getPost();

		for (Post post : posts) {
			System.out.println("Título: " + post.getTitulo());
			System.out.println("Data: " + post.getData());
			System.out.println("Criado por: " + post.getCriadoPor());
			System.out.println("Última edição por: " + post.getEditadoPor());
			System.out.println(post.getConteudo());
			System.out.println("====================================");
		}
	}
}