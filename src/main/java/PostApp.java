import api.placeholder.Post;
import api.placeholder.Resources;
import api.placeholder.Todo;
import api.placeholder.URIGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;

public class PostApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Wpisz numer zasobu: ");
        if (scanner.hasNextInt()) {
            int id = scanner.nextInt();
            System.out.println("Wpisz nazwę zasobu:");
            Arrays.asList(Resources.values()).forEach(System.out::println); //wyświetlamy wszystkie zasoby
            String resourceName = scanner.next().toUpperCase();  //wczytujemy nazwę zasoby
            Resources resource = Resources.valueOf(resourceName);//zwracamy stałą zasobu na podstawie jej nazwy
            URIGenerator gen = new URIGenerator();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(gen.getForId(resource, id))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            switch (resource) {
                case POSTS:
                    final Post post = mapper.readValue(response.body(), Post.class);
                    System.out.println(post);
                    break;
                case TODOS:
                    final Todo todo = mapper.readValue(response.body(), Todo.class);
                    System.out.println(todo);
                    break;
            }
        } else {
            System.out.println("Niepoprawny wpisany numer posta!");
        }
    }
}
