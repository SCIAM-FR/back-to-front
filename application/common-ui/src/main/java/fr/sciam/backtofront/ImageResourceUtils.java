package fr.sciam.backtofront;

import java.net.URL;
import java.util.Objects;

/**
 * Utility class used to retrieved image resources from common-ui
 */
public final class ImageResourceUtils {

  private static final String BASE_FOLDER = "/images/";
  private static final String EXTENSION = ".png";

  private ImageResourceUtils() {
    //
  }

  public static URL getImageResource(String imageName) {
    String path = BASE_FOLDER + imageName + EXTENSION;
    URL resource = ImageResourceUtils.class.getResource(path);
    Objects.requireNonNull(resource, () -> "Image resource could not be found : " + path);
    return resource;
  }
}
