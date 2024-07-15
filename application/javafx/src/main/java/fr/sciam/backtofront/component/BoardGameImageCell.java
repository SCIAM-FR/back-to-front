package fr.sciam.backtofront.component;

import fr.sciam.backtofront.ImageResourceUtils;
import fr.sciam.backtofront.viewmodel.BoardGameViewData;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class BoardGameImageCell extends TableCell<BoardGameViewData, Number> {
  private final ImageView imageView;

  private BoardGameImageCell() {
    this.imageView = new ImageView();
    this.imageView.setPreserveRatio(true);
  }

  public static TableCell<BoardGameViewData, Number> newBoardGameImageCell() {
    return new BoardGameImageCell();
  }

  @Override
  protected void updateItem(final Number id, final boolean empty) {
    super.updateItem(id, empty);
    if (empty || id == null) {
      this.setGraphic(null);
    } else {
      URL resource = ImageResourceUtils.getImageResource(String.valueOf(id));
      Image image = new Image(resource.toExternalForm(), true);
      this.imageView.setImage(image);
      this.setGraphic(this.imageView);
    }
  }
}