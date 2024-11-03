package com.example.URLShortner.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private String requestkey;


    @JsonProperty("URL")
    private String URL; // Matches "URL"

}
