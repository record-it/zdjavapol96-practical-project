package api.swapi.repository;

import api.ApiJsonStringLoader;
import api.swapi.model.Film;
import api.swapi.model.Page;
import api.swapi.model.PageFilm;
import api.swapi.model.Planets;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class FilmRepository {
    private static final String URI_PLANET = "https://swapi.dev/api/films";
    private static final ObjectMapper mapper = new ObjectMapper();

    public List<Film> findAll(){
        try {
            final HttpResponse<String> resp = ApiJsonStringLoader.get(new URI(URI_PLANET));
            final Page<Film> page = mapper.readValue(resp.body(), PageFilm.class);
            return page.getResults();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

}
