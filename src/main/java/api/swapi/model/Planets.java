package api.swapi.model;

import lombok.Data;

import java.util.List;
@Data
public class Planets {
    private int count;
    private String next;
    private String previous;
    private List<Planet> results;
}
