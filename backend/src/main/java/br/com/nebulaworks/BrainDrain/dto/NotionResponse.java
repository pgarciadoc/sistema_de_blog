package src.main.java.br.com.nebulaworks.BrainDrain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionResponse {
    private List<src.main.java.br.com.nebulaworks.BrainDrain.dto.NotionPage> results;

    public List<src.main.java.br.com.nebulaworks.BrainDrain.dto.NotionPage> getResults() {
        return results;
    }
}
