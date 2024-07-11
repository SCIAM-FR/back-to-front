package fr.sciam.backtofront.persistence.entities;

import fr.sciam.backtofront.domain.Category;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BoardGameEntity extends PanacheEntity {

  public String name;
  public int releaseYear;

  @Type(JsonType.class)
  @Column(columnDefinition = "json")
  public final List<Category> categories = new ArrayList<>();
}
