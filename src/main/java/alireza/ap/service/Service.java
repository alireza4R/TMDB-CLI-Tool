package alireza.ap.service;

import alireza.ap.client.ApiClient;
import alireza.ap.model.MovieInformation;
import alireza.ap.model.TmdbResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Service {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public Service (ObjectMapper objectMapper, ApiClient apiClient){
        this.apiClient = apiClient;
                this.objectMapper = objectMapper;
    }

    public List<MovieInformation> getMovies(String instruction) throws IOException, InterruptedException {
        TmdbResponse response = objectMapper.readValue(apiClient.fetch(instruction), TmdbResponse.class);
        return response.results();
    }
}
