package alireza.ap;

import alireza.ap.client.ApiClient;
import alireza.ap.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String apiToken;
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient;


        try {
            while (true) {
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

                    switch (input){
                        case "0":
                            return;

                        case "1":

                        case "2":

                        case "3":

                        case "4":

                        default: System.out.println("Wrong entry try again");

                    }
                }
            }
        }

    }
}