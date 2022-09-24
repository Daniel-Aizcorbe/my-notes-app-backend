package tag.color;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Color {

  private String color_code;
  private String color_format;

  public Color(String color_code, String color_format) {
    this.color_code = color_code;
    this.color_format = color_format;
  }
}
