package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.AssistantsDTO;
import entities.Assistant;
import errorhandling.API_Exception;
import facades.AssistantFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("assistant")
public class AssistantResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final AssistantFacade instance = AssistantFacade.getInstance(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    Assistant assistant = new Assistant();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return gson.toJson(instance.getAllAssistants());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String getAll() {
        AssistantsDTO a = instance.getAllAssistants();
            return gson.toJson(a);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response newAssistant (String jsonString) throws API_Exception {
        String name;
        String language;
        int yearExperience;
        int priceHour;

        try {
            JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
            name = jsonObject.get("assName").getAsString();
            assistant.setName(name);
            language = jsonObject.get("assLanguage").getAsString();
            assistant.setLanguage(language);
            yearExperience = jsonObject.get("assYearExperience").getAsInt();
            assistant.setYearExperience(yearExperience);
            priceHour = jsonObject.get("assPriceHour").getAsInt();
            assistant.setPriceHour(priceHour);

            instance.createAssistant(assistant);
        } catch (Exception e) {
            throw new API_Exception("Error", 404, e);
        } return null;
    }
}
