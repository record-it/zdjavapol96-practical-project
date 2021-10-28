package api.swapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private int count;
    private String next;
    private String previous;
    private List<T> results;
}
