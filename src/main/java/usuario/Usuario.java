package usuario;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import nota.Nota;
import usuario.tipocuenta.TipoCuenta;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  Long id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type")
  private TipoCuenta tipoCuenta = TipoCuenta.GRATIS;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private final Set<Nota> notas = new HashSet<>();

  public Usuario(String name, String password) {
    this.name = name;
    this.password = password;
  }

  Usuario() {

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
