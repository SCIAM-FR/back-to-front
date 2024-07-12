package fr.sciam.backtofront;

import fr.sciam.backtofront.domain.Category;
import fr.sciam.backtofront.persistence.entities.BoardGameEntity;
import io.quarkiverse.fx.FxStartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;

@ApplicationScoped
public class FxApplication {

  private Label label;

  void onFxStartup(@Observes FxStartupEvent event) {

    // TODO
    TableView<BoardGameEntity> table = new TableView<>();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

    TableColumn<BoardGameEntity, Long> idColumn = new TableColumn<>("ID");
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<BoardGameEntity, Long> imageColumn = new TableColumn<>("Image");
    imageColumn.setPrefWidth(150);
    imageColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    imageColumn.setCellFactory(_ -> new TableCell<>() {
      private final ImageView imageView = new ImageView();
      private final HBox hbox = new HBox(this.imageView);
      {
        this.imageView.setPreserveRatio(true);
//        this.hbox.setAlignment(Pos.CENTER);
      }

      @Override
      protected void updateItem(Long id, boolean empty) {
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
    });

    TableColumn<BoardGameEntity, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<BoardGameEntity, Integer> yearColumn = new TableColumn<>("Release Year");
    yearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

    TableColumn<BoardGameEntity, List<Category>> categoriesColumn = new TableColumn<>("Categories");
    categoriesColumn.setCellValueFactory(new PropertyValueFactory<>("categories"));

    table.getColumns().addAll(
      idColumn,
      imageColumn,
      nameColumn,
      yearColumn,
      categoriesColumn
    );

    // Sample data
    List<BoardGameEntity> entities = BoardGameEntity.listAll();
    ObservableList<BoardGameEntity> data = FXCollections.observableList(entities);

    table.setItems(data);

    Stage stage = event.getPrimaryStage();

    VBox root = new VBox(table);
    VBox.setVgrow(table, Priority.ALWAYS);
    Scene scene = new Scene(root, 800, 700);
    stage.setScene(scene);
    stage.show();
  }
}