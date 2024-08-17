package org.codecaveofandrew.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import org.codecaveofandrew.model.Film;
import org.codecaveofandrew.repository.FilmRepository;

@Path("/film")
public class FilmResource {

  @Inject
  FilmRepository filmRepository;

  @GET
  @Path("/list")
  public List<Film> listFilm() {
    return filmRepository.find20QueriesOrderById();
  }
}
