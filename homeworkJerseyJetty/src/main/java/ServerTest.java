import javax.sound.sampled.Line;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
/**
 *
 * @author duylinh
 */
@Path("/information")
public class ServerTest {


    static List<Information> database = new ArrayList<Information>();




    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfo(@PathParam("id") String id) {
        System.out.println("get Id"+id);
        if(id == null || id.trim().length() == 0) {
            return Response.serverError().entity("please give id").build();
        }
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId().compareTo(id)==0) {
                return Response.ok(database.get(i).toString(), MediaType.APPLICATION_JSON).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Not found ID: " + id).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createInfo(String info) {
        //POST
        System.out.println("post Id");
        try {
            Gson gson = new Gson();
            Information infomation;
            infomation = gson.fromJson(info,Information.class);
            database.add(infomation);
            return Response.ok(new Gson().toJson(infomation)).build();
        }
        catch (JsonParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No: " + info).build();
        }
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInfo(@PathParam("id") String id, String info) {
        System.out.println("put Id"+id);
        if(id == null || id.trim().length() == 0) {
            return Response.serverError().entity("pleased give id").build();
        }
        try {
            Gson gson = new Gson();
            Information information;
            information = gson.fromJson(info, Information.class);
            for (int i = 0; i < database.size(); i++) {
                if (database.get(i).getId().compareTo(id)==0) {
                    database.get(i).setContent(information.getContent(), information.getCreated_by());
                    return Response.ok(database.get(i).toString(), MediaType.APPLICATION_JSON).build();
                }
            }
            return Response.status(Response.Status.NOT_FOUND).entity("Not found for ID: " + id).build();
        }
        catch (JsonParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No " + info).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteInfo(@PathParam("id") String id) {
        System.out.println("delete Id"+id);
        if(id == null || id.trim().length() == 0) {
            return Response.serverError().entity("pleased giv id").build();
        }
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId().compareTo(id)==0) {
                database.remove(i);
                return Response.ok("Deleted Note at Id " + id).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Not found for ID: " + id).build();
    }

}