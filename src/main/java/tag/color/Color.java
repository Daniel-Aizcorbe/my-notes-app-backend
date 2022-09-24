package tag.color;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Color {

  @Column(name = "tag_color_code")
  private String color_code;

  @Column(name = "tag_color_format")
  private String color_format;

  public Color(String color_code, String color_format) {
    this.color_code = color_code;
    this.color_format = color_format;
  }

  Color() {

  }
}
