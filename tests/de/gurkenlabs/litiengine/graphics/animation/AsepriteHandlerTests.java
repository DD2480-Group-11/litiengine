package de.gurkenlabs.litiengine.graphics.animation;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.resources.SpritesheetResource;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.resources.ImageFormat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
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
  
   @Test
  public void importAnimationTest() {
    try {
      Animation animation = AsepriteHandler.importAnimation("tests/de/gurkenlabs/litiengine/graphics/animation/aseprite_test_animation/Sprite-0001.json");
      assertEquals(300, animation.getTotalDuration());
      assertEquals("Sprite-0001-sheet", animation.getName());

      Spritesheet spriteSheet = animation.getSpritesheet();
      assertEquals(32, spriteSheet.getSpriteHeight());
      assertEquals(32, spriteSheet.getSpriteWidth());
      assertEquals(3, spriteSheet.getTotalNumberOfSprites());
      assertEquals(ImageFormat.PNG, spriteSheet.getImageFormat());
    }
    catch(FileNotFoundException e) {
      fail(e.getMessage());
    }
    catch(AsepriteHandler.ImportAnimationException e) {
      fail(e.getMessage());
    }
}
