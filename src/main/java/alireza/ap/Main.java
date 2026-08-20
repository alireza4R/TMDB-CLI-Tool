package alireza.ap;

import alireza.ap.client.ApiClient;
import alireza.ap.model.MovieInformation;
import alireza.ap.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String apiToken;
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient;


        try {

                System.out.println("Paste your api token: ");
                apiToken = scanner.nextLine();
                apiClient = new ApiClient(HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build(), apiToken);
                Service service = new Service(new ObjectMapper(),apiClient);
                while (true) {
                    String input;
                    System.out.println("0.Exit");
                    System.out.println("1.Now Playing Movies");
                    System.out.println("2.Popular Movies");
                    System.out.println("3.Top Rated Movies");
                    System.out.println("4.Upcoming Movies");
                    input = scanner.next();
                    List<MovieInformation> list = null;

                    switch (input){
                        case "0":
                            return;

                        case "1":
                            list = service.getMovies("now_playing");
                            break;
                        case "2":
                            list = service.getMovies("popular");
                            break;
                        case "3":
                            list = service.getMovies("top_rated");
                            break;
                        case "4":
                            list = service.getMovies("upcoming");
                            break;
                        default: System.out.println("Wrong entry try again");

                    }
                    printAll(list);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static void printAll(List<MovieInformation> movies) {
        Optional.ofNullable(movies)
                .orElseGet(List::of)
                .forEach(movie -> System.out.println(
                        "==============================================================" + "\n" +
                        "Title: " + movie.title() + "\n" +
                        "------------------------" + "\n" +
                        "ID: " + movie.id() + "\n" +
                        "Language: " + movie.language() + "\n" +
                        "Release Date: " + movie.release_date() + "\n" +
                        "Overview: " + movie.overview() + "\n" +
                        "Popularity: " + movie.popularity() + "\n" +
                        "Rating: " + movie.rating() + "\n"));
    }
}