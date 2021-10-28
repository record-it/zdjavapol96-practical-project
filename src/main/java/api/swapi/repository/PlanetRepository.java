package api.swapi.repository;

import api.ApiJsonStringLoader;
import api.swapi.model.Planet;
import api.swapi.model.Planets;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PlanetRepository {
    private static final String URI_PLANET = "https://swapi.dev/api/planets";
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Planet> findAll(){
        try {
            final HttpResponse<String> resp = ApiJsonStringLoader.get(new URI(URI_PLANET));
            final Planets planets = mapper.readValue(resp.body(), Planets.class);
            return planets.getResults();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    public Optional<Planet> findById(int id){
        try {
            final HttpResponse<String> resp = ApiJsonStringLoader.get(new URI(URI_PLANET+"/"+id));
            if(resp != null) {
                return Optional.of(mapper.readValue(resp.body(), Planet.class));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
}
