package br.com.nebulaworks.BrainDrain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NotionPage {

    @JsonProperty("id")
    private String id;

    @JsonProperty("properties")
    private Map<String, Object>
            properties;
    private String url;

}

