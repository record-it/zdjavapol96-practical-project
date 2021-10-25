package api.placeholder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Repository {
    private HttpClient client = HttpClient.newHttpClient();
    private URIGenerator generator = new URIGenerator();
    private ObjectMapper mapper = new ObjectMapper();
    public List<Post> findAllPosts(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(generator.getForAll(Resources.POSTS))
                    .build();
            final HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            final Post[] posts = mapper.readValue(res.body(), Post[].class);
            return Arrays.asList(posts);
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
