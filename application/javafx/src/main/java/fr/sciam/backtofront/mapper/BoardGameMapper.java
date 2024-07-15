package fr.sciam.backtofront.mapper;

import fr.sciam.backtofront.persistence.entities.BoardGameEntity;
import fr.sciam.backtofront.viewmodel.BoardGameViewData;
import jakarta.inject.Singleton;

@Singleton
public class BoardGameMapper implements ViewModelMapper<BoardGameEntity, BoardGameViewData> {

  @Override
  public BoardGameViewData newViewModelInstance() {
    return new BoardGameViewData();
  }

  @Override
  public void update(
    final BoardGameEntity domainObject,
    final BoardGameViewData viewModelObject) {

    viewModelObject.getId().set(domainObject.id);
    viewModelObject.getName().set(domainObject.name);
    viewModelObject.getReleaseYear().set(domainObject.releaseYear);
    viewModelObject.getCategories().setAll(domainObject.categories);
  }
}
