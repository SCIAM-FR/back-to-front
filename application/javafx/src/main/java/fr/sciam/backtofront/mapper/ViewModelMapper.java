package fr.sciam.backtofront.mapper;

/**
 * Mapper used to map a domain object to a JavaFX view model object
 * @param <D> domain object
 * @param <V> view model object
 */
public interface ViewModelMapper<D, V> {

  /**
   * Create the view model object from a domain object
   * @param domainObject the domain object
   * @return created view model object
   */
  default V create(final D domainObject) {
    V viewModelObject = this.newViewModelInstance();
    this.update(domainObject, viewModelObject);
    return viewModelObject;
  }

  /**
   * Factory to create a new view model object instance
   * @return newly created view model object instance
   */
  V newViewModelInstance();

  /**
   * Update a view model object with a domain object
   * @param domainObject the domain object
   * @param viewModelObject the view model object to be updated
   */
  void update(D domainObject, V viewModelObject);
}
