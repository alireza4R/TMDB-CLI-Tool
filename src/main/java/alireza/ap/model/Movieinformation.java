package alireza.ap.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Movieinformation(int id,
                               @JsonProperty("original_language") String language,
                               @JsonProperty("original_title") String title,
                               String overview,
                               Double popularity,
                               String release_date,
                               @JsonProperty("vote_average") Double rating

) {}
