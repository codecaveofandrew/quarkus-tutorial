package org.codecaveofandrew.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.codecaveofandrew.model.Film;

@ApplicationScoped
public class FilmRepository implements PanacheRepository<Film> {
  public List<Film> find20QueriesOrderById() {
    return find("ORDER BY id DESC").page(0, 20).list();
  }
}
