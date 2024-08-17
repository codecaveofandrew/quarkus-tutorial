package org.codecaveofandrew.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "film_id")
  private short filmId;

  @Basic
  @Column(name = "title")
  private String title;

  @Basic
  @Column(name = "description")
  private String description;

  @Override
  public String toString() {
    return "Film{" +
        "filmId=" + filmId +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
