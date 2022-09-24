package nota;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import nota.estadonota.EstadoNota;
import tag.Tag;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Notas")
public class Nota {

  @Id
  @GeneratedValue
  @Column(name = "nota_id", nullable = false)
  private Long id;

  @Column(name = "nota_nombre", nullable = false)
  private String name;

  @Column(name = "nota_cuerpo", nullable = false)
  private String text;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "TAGS_POR_NOTA",
      joinColumns = @JoinColumn(name = "nota_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  @OrderColumn(name = "tag_posicion")
  private Set<Tag> tags;

  @Column(name = "nota_estado", nullable = false)
  @Enumerated(EnumType.STRING)
  private EstadoNota grupo;

  Nota() {

  }

  public Nota(Long id, String name, String texto, Set<Tag> tags, EstadoNota estado) {
    this.grupo = estado;
    this.id = id;
    this.name = name;
    this.text = texto;
    this.tags = tags;
  }

  public void archivar() {
    grupo = EstadoNota.ARCHIVADA;
  }

  public void setFavorita() {
    grupo = EstadoNota.FAVORITA;
  }

  public void desmarcar() {
    grupo = EstadoNota.NINGUNA;
  }
}
