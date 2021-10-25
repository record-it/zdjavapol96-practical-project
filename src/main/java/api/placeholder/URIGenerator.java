package api.placeholder;

import java.net.URI;
import java.net.URISyntaxException;

public class URIGenerator {
    private static final String URI_HOST = "https://jsonplaceholder.typicode.com/";

    public URI getForAll(Resources resource) throws URISyntaxException {
        return new URI(String.format("%s%s",URI_HOST,resource.toString().toLowerCase()));
    }

    public URI getForId(Resources resource, int id) throws URISyntaxException {
        return new URI(String.format("%s%s/%d", URI_HOST, resource.toString().toLowerCase(),id));
    }
}
