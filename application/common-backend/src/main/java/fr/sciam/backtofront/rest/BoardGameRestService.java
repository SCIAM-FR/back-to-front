package fr.sciam.backtofront.rest;

import fr.sciam.backtofront.persistence.entities.BoardGameEntity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("boardgame")
public class BoardGameRestService {

  @GET
  public List<BoardGameEntity> getAll() {
    return BoardGameEntity.listAll();
  }
}
