package api.placeholder;

import lombok.Data;

@Data
public class Todo {
    private int id;
    private int UserId;
    private String title;
    private boolean completed;
}
