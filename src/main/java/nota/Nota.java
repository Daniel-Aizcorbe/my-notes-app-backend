package nota;

import lombok.Getter;
import lombok.Setter;
import nota.estadonota.EstadoNota;
import tag.Tag;

import java.util.Set;

public class Nota {

  @Getter
  @Setter
  private String name;

  private Set<Tag> tags;

  private EstadoNota grupo = EstadoNota.NINGUNA;

  private String text;

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
