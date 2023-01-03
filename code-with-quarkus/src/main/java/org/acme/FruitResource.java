package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/fruit")
public class FruitResource {

    /*  @GET
      @Path("/hello")
      @Produces(MediaType.APPLICATION_JSON)
      public String hello() {
          return "Hello from RESTEasy Reactive ";
      }
  */
    @Inject
    FruitService fruitService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> listFruit() {
        return fruitService.listFruit();
    }

    @POST
    public void newFruit(FruitDTO fruitDTO) {
        fruitService.newFruit(fruitDTO);
    }
}