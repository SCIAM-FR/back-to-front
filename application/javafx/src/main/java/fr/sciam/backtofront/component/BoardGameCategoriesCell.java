package fr.sciam.backtofront.component;

import fr.sciam.backtofront.domain.Category;
import fr.sciam.backtofront.viewmodel.BoardGameViewData;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;

import java.util.stream.Collectors;

public class BoardGameCategoriesCell extends TableCell<BoardGameViewData, ObservableList<Category>> {

  private BoardGameCategoriesCell() {
    // Instantiated by factory
  }

  public static TableCell<BoardGameViewData, ObservableList<Category>> newBoardGameImageCell() {
    return new BoardGameCategoriesCell();
  }

  @Override
  protected void updateItem(final ObservableList<Category> categories, final boolean empty) {
    super.updateItem(categories, empty);
    if (empty || categories == null || categories.isEmpty()) {
      this.setText(null);
    } else {
      this.setText(categories.stream().map(Category::name).collect(Collectors.joining(", ")));
    }
  }
}