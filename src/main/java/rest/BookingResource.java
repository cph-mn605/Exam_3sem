package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BookingDTO;
import dtos.BookingsDTO;
import facades.AssistantFacade;
import facades.BookingFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("booking")
public class BookingResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final BookingFacade instance = BookingFacade.getInstance(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForBooking() {
        return gson.toJson(instance.getAllBookings());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allbooking")
    public String getAllBookings() {
        BookingsDTO b = instance.getAllBookings();
            return gson.toJson(b);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete")
    public String deleteBooking(BookingDTO dto) {
        System.out.println("DELETE REQUEST: deleteBooking");
        System.out.println("JSON recieved: " + dto);
        return gson.toJson(instance.deleteBooking(dto));
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public String deleteBooking(@PathParam("id") int bookingId){
        System.out.println("DELETE REQUEST: deleteBooking | Params(Booking id: " + bookingId + ")");
        return gson.toJson(instance.deleteBooking(bookingId));
    }
}