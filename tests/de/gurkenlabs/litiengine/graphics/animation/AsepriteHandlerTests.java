package de.gurkenlabs.litiengine.graphics.animation;

import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.resources.ImageFormat;

public class AsepriteHandlerTests {

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
}
