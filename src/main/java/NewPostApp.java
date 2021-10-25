import api.placeholder.Post;
import api.placeholder.Repository;

import java.util.List;

public class NewPostApp {
    static Repository repository = new Repository();
    public static void main(String[] args) {
        List<Post> postList = repository.findAllPosts();
        int userId = 4;
        postList.stream().filter(p -> p.getUserId() == userId).forEach(System.out::println);
    }
}
