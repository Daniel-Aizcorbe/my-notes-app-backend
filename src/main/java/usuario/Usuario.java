package usuario;

import lombok.Getter;
import lombok.Setter;
import nota.Nota;
import usuario.tipocuenta.TipoCuenta;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Usuario {

  @Setter
  private String name;

  @Setter
  private String password;

  private TipoCuenta tipoCuenta = TipoCuenta.GRATIS;

  private final Set<Nota> notas = new HashSet<>();

  public Usuario(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public void agregarNota(Nota nota) {
    notas.add(nota);
  }

  public void eliminarNota(Nota nota) {
    notas.remove(nota);
  }

  public void convertirseEnPremium() {
    tipoCuenta = TipoCuenta.PREMIUM;
  }

  public void pasarAGratis() {
    tipoCuenta = TipoCuenta.GRATIS;
  }

}
