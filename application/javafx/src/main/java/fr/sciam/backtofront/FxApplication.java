package fr.sciam.backtofront;

import fr.sciam.backtofront.component.BoardGameCategoriesCell;
import fr.sciam.backtofront.component.BoardGameImageCell;
import fr.sciam.backtofront.domain.Category;
import fr.sciam.backtofront.mapper.BoardGameMapper;
import fr.sciam.backtofront.persistence.entities.BoardGameEntity;
import fr.sciam.backtofront.viewmodel.BoardGameViewData;
import io.quarkiverse.fx.FxStartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

@ApplicationScoped
public class FxApplication {

  @Inject
  BoardGameMapper boardGameMapper;

  void onFxStartup(@Observes final FxStartupEvent event) {

    // TODO
    TableView<BoardGameViewData> table = new TableView<>();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

    TableColumn<BoardGameViewData, Number> idColumn = new TableColumn<>("ID");
    idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());

    TableColumn<BoardGameViewData, Number> imageColumn = new TableColumn<>("Image");
    imageColumn.setPrefWidth(150);
    imageColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
    imageColumn.setCellFactory(_ -> BoardGameImageCell.newBoardGameImageCell());

    TableColumn<BoardGameViewData, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());

    TableColumn<BoardGameViewData, Number> yearColumn = new TableColumn<>("Release Year");
    yearColumn.setCellValueFactory(cellData -> cellData.getValue().getReleaseYear());

    TableColumn<BoardGameViewData, ObservableList<Category>> categoriesColumn = new TableColumn<>("Categories");
    categoriesColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCategories()));
    categoriesColumn.setCellFactory(_ -> BoardGameCategoriesCell.newBoardGameImageCell());


    table.getColumns().addAll(idColumn, imageColumn, nameColumn, yearColumn, categoriesColumn);

    // Load sample data
    List<BoardGameViewData> entities = BoardGameEntity.<BoardGameEntity>listAll()
      .stream()
      .map(this.boardGameMapper::create)
      .toList();
    ObservableList<BoardGameViewData> data = FXCollections.observableList(entities);

    table.setItems(data);

    // Display stage
    Stage stage = event.getPrimaryStage();

    VBox root = new VBox(table);
    VBox.setVgrow(table, Priority.ALWAYS);
    Scene scene = new Scene(root, 800, 700);
    stage.setScene(scene);
    stage.show();
  }
}