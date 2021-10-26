package api;

import api.placeholder.Resources;
import api.placeholder.URIGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiJsonStringLoader {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> get(URI uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        final HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        return res;
    }
}
