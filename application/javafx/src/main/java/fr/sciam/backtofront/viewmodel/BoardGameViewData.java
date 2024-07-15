package fr.sciam.backtofront.viewmodel;

import fr.sciam.backtofront.domain.Category;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class BoardGameViewData {

  private final LongProperty id = new SimpleLongProperty();
  private final StringProperty name = new SimpleStringProperty();
  private final IntegerProperty releaseYear = new SimpleIntegerProperty();
  private final ObservableList<Category> categories = FXCollections.observableArrayList();

}
