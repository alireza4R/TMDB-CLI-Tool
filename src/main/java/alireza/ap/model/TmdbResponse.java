package alireza.ap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record TmdbResponse(List<MovieInformation> results) {
}
