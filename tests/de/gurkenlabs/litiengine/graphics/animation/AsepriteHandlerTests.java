package de.gurkenlabs.litiengine.graphics.animation;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.resources.SpritesheetResource;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

public class AsepriteHandlerTests {


  /**
   * Test that just create a json and prints in to standard output.
   */
  @Test
  public void exportAnimationTest() {
    String spritesheetPath = "C:/Users/Nikla/Documents/Programmering/SoftwareFundamentals/Assignment-3-EC/litiengine/tests/de/gurkenlabs/litiengine/graphics/animation/aseprite_test_animation/Sprite-0001-sheet.png";
    BufferedImage image = new BufferedImage(96, 32, BufferedImage.TYPE_4BYTE_ABGR);
    Spritesheet spritesheet = new Spritesheet(image, spritesheetPath, 32, 32);
    AsepriteHandler aseprite = new AsepriteHandler();
    String result = aseprite.exportAnimation(new SpritesheetResource(spritesheet));
    System.out.println(result);

  }
}
