package br.com.nebulaworks.BrainDrain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionResponse {
    private List<NotionPage> results;

    public List<NotionPage> getResults() {
        return results;
    }
}
