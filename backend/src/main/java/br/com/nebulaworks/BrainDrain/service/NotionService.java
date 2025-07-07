package src.main.java.br.com.nebulaworks.BrainDrain.service;

import src.main.java.br.com.nebulaworks.BrainDrain.dto.NotionPage;
import src.main.java.br.com.nebulaworks.BrainDrain.dto.NotionResponse;
import br.com.nebulaworks.BrainDrain.model.Post;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NotionService {
    private static final String NOTION_API_URL = "https://api.notion.com/v1/databases/20b4b12fed588090a07bf1548ba9f5cc/query";
    private static final String TOKEN = "Bearer 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";
    private static final String DATABASE_ID = "20b4b12fed588090a07bf1548ba9f5cc";


    public static List<Post> getPost() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer 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");
        headers.set("Notion-Version", "2022-06-28");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
          NOTION_API_URL,
          HttpMethod.POST,
          requestEntity,
          String.class
        );

        String responseBody = responseEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        List<Post> posts = new ArrayList<>();

        try{
            NotionResponse response = mapper.readValue(responseBody, NotionResponse.class);
            for (NotionPage page: response.getResults()) {
                String id = page.getId();
                String conteudo = getPageContent(id);

                Map<String, Object> props = page.getProperties();

                Map nomeMap = (Map) props.get("Nome");
                List titleList = (List) nomeMap.get("title");
                Map text = (Map) ((Map) titleList.get(0)).get("text");
                String titulo = (String) text.get("content");

                String data = null;
                Map dataMap = (Map) props.get("Data");
                if (dataMap != null && dataMap.get("date") != null) {
                    Map dateInner = (Map) dataMap.get("date");
                    data = (String) dateInner.get("start");
                }

                Map criadoPorMap = (Map) props.get("Criado por");
                Map criadoPorUser = (Map) criadoPorMap.get("created_by");
                String criadoPor = (String) criadoPorUser.get("name");

                // Última edição por
                Map editadoMap = (Map) props.get("Última edição por");
                Map editadoPorUser = (Map) editadoMap.get("last_edited_by");
                String editadoPor = (String) editadoPorUser.get("name");

                String url = page.getUrl();

                // Criar o objeto Post
                Post post = new Post();

                post.setId(id);
                post.setTitulo(titulo);
                post.setData(data);
                post.setCriadoPor(criadoPor);
                post.setEditadoPor(editadoPor);
                post.setUrl(url);
                post.setConteudo(conteudo);


                posts.add(post);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return posts;
    }

    public static Post getPostById(String id) {
        List<Post> posts = getPost();
        return posts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
    }

    private static String getPageContent(String pageId) {
        String url = "https://api.notion.com/v1/blocks/" + pageId + "/children";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TOKEN);
        headers.set("Notion-Version", "2022-06-28");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    String.class
            );

            String responseBody = response.getBody();

            // Processa o JSON para extrair texto dos blocos
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(responseBody);


            StringBuilder contentBuilder = new StringBuilder();

            JsonNode results = rootNode.get("results");
            if (results != null && results.isArray()) {
                for (JsonNode block : results) {
                    String type = block.get("type").asText();
                    JsonNode richTextArray = block.get(type).get("rich_text");

                    if (richTextArray != null && richTextArray.isArray()) {
                        for (JsonNode textNode : richTextArray) {
                            JsonNode text = textNode.get("text");
                            if (text != null && text.get("content") != null) {
                                String content = text.get("content").asText();

                                // Adicione formatação básica com base no tipo
                                switch (type) {
                                    case "heading_1":
                                        contentBuilder.append("<h1>").append(content).append("</h1>\n");
                                        break;
                                    case "heading_2":
                                        contentBuilder.append("<h2>").append(content).append("</h2>\n");
                                        break;
                                    case "heading_3":
                                        contentBuilder.append("<h3>").append(content).append("</h3>\n");
                                        break;
                                    case "bulleted_list_item":
                                        contentBuilder.append("<li>").append(content).append("</li>\n");
                                        break;
                                    case "numbered_list_item":
                                        contentBuilder.append("<li>").append(content).append("</li>\n");
                                        break;
                                    case "quote":
                                        contentBuilder.append("<blockquote>").append(content).append("</blockquote>\n");
                                        break;
                                    case "paragraph":
                                    default:
                                        contentBuilder.append("<p>").append(content).append("</p>\n");
                                        break;
                                }
                            }
                        }
                    }
                }
            }

            return contentBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao buscar conteúdo";
        }
    }

}
