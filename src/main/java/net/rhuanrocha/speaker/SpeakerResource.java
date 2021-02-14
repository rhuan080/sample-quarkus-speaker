package net.rhuanrocha.speaker;


import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/speakers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SpeakerResource {

    @GET
    public List<Speaker> list(){
        return Speaker.listAll();
    }

    @POST
    public Response save (Speaker speaker){
        speaker.id = null;
        speaker.persist();
        return Response.created(URI.create(String.format("/speakers/{id}", speaker.id))).build();
    }

    @GET
    @Path("/event/{idEvent}")
    public List<Speaker> listByEvent(@PathParam("idEvent") Long idEvent){
        return Speaker.list("idEvent", idEvent);
    }


}
