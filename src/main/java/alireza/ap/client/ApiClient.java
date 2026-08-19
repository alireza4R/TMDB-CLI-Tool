package alireza.ap.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private final HttpClient httpClient;
    private final String apiToken;

    public ApiClient(HttpClient httpClient, String apiToken) {
        this.httpClient = httpClient;
        this.apiToken = apiToken;
    }

    public String fetch(String instruction) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://api.themoviedb.org/3/movie/" + instruction)).header("Authorization","Bearer " + apiToken)
                .header("accept","application/json").GET().build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException("TMDB API Error: HTTP " + response.statusCode() + " - " + response.body());
        }
        return response.body();
    }
}
