package api.swapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Planet {
    private String rotation_period;
    private List<String> residents;
    private String name;
    private String diameter;
    private String orbital_period;
    private String surface_water;
    private String climate;
    private String gravity;
    private String terrain;
    private String population;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
}
