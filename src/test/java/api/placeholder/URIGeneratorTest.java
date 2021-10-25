package api.placeholder;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class URIGeneratorTest {

    @Test
    public void shouldReturnValidURIForPosts() throws URISyntaxException {
        //given
        URIGenerator gen = new URIGenerator();
        //when
        final URI uri = gen.getForAll(Resources.POSTS);
        //then
        assertEquals("https://jsonplaceholder.typicode.com/posts", uri.toASCIIString());
    }

    @Test
    public void test() throws URISyntaxException {
        //given
        URIGenerator gen = new URIGenerator();
        //when
        final URI uri = gen.getForId(Resources.POSTS, 1);
        //then
        assertEquals("https://jsonplaceholder.typicode.com/posts/1", uri.toASCIIString());
    }
}