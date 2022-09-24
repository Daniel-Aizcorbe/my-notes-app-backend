package tag;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tag.color.Color;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Tags")
public class Tag {

  @Id
  @GeneratedValue
  @Column(name = "tag_id")
  Long id;

  @Embedded
  private Color color;

  @Column(name = "tag_nombre")
  private String name;

  public Tag(Color color, String nombre) {
    this.name = nombre;
    this.color = color;
  }

  Tag() {

  }
}
