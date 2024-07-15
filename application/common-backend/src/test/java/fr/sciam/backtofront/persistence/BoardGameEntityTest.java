package fr.sciam.backtofront.persistence;

import fr.sciam.backtofront.domain.Category;
import fr.sciam.backtofront.persistence.entities.BoardGameEntity;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class BoardGameEntityTest {

  @Test
  @Transactional
  void testAllBoardGamesAreImported() {
    List<BoardGameEntity> boardGames = BoardGameEntity.listAll();

    assertThat(boardGames).hasSize(10);

    Map<String, BoardGameEntity> boardGameMap = boardGames.stream()
      .collect(Collectors.toMap(bg -> bg.name, bg -> bg));

    // Test each board game
    assertBoardGameMatches(boardGameMap, "Gloomhaven", 2017, Category.COOPERATIVE, Category.DUNGEON_CRAWLER);
    assertBoardGameMatches(boardGameMap, "Terraforming Mars", 2016, Category.STRATEGY);
    assertBoardGameMatches(boardGameMap, "Pandemic", 2008, Category.COOPERATIVE, Category.STRATEGY);
    assertBoardGameMatches(boardGameMap, "Catan", 1995, Category.STRATEGY, Category.RESOURCE_MANAGEMENT);
    assertBoardGameMatches(boardGameMap, "Ticket to Ride", 2004, Category.FAMILY, Category.STRATEGY);
    assertBoardGameMatches(boardGameMap, "Carcassonne", 2000, Category.TILE_PLACEMENT, Category.STRATEGY);
    assertBoardGameMatches(boardGameMap, "Scythe", 2016, Category.STRATEGY, Category.AREA_CONTROL);
    assertBoardGameMatches(boardGameMap, "Azul", 2017, Category.ABSTRACT, Category.TILE_PLACEMENT);
    assertBoardGameMatches(boardGameMap, "Codenames", 2015, Category.PARTY, Category.WORD_GAME);
    assertBoardGameMatches(boardGameMap, "7 Wonders", 2010, Category.CARD_DRAFTING, Category.STRATEGY);
  }

  @Test
  @TestTransaction
  void testBoardGameInsertion() {
    BoardGameEntity entity = new BoardGameEntity();
      entity.name = "Dune : Imperium";
      entity.releaseYear = 2020;
      entity.categories.add(Category.STRATEGY);

    BoardGameEntity byId = BoardGameEntity.findById(11);
    assertThat(byId).isNull();

    entity.persist();

    byId = BoardGameEntity.findById(11);
    assertThat(byId.name).isEqualTo(entity.name);
    assertThat(byId.releaseYear).isEqualTo(entity.releaseYear);
    assertThat(byId.categories).containsExactlyInAnyOrder(entity.categories.toArray(new Category[] {}));
  }

  private static void assertBoardGameMatches(
    final Map<String, BoardGameEntity> boardGameMap,
    final String name,
    final int releaseYear,
    final Category... expectedCategories) {

    BoardGameEntity boardGame = boardGameMap.get(name);
    assertThat(boardGame).isNotNull();
    assertThat(boardGame.name).isEqualTo(name);
    assertThat(boardGame.releaseYear).isEqualTo(releaseYear);
    assertThat(boardGame.categories).containsExactlyInAnyOrder(expectedCategories);
  }
}
git