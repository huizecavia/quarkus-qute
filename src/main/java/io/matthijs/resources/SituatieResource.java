package io.matthijs.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.matthijs.models.Antwoord;
import io.matthijs.models.Situatie;
import io.matthijs.models.Vraag;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Path("/situatie")
public class SituatieResource {

    private final Template situatie;

    public SituatieResource(Template situatie) {
        this.situatie = situatie;
    }


    @Path("/get")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        List<Antwoord> antwoordList = new ArrayList<>();
        antwoordList.add(new Antwoord("Ja", "krijg AOW"));
        antwoordList.add(new Antwoord("nee", "krijg geen AOW"));
        antwoordList.add(new Antwoord("onbekend", "hoezo?"));
        Vraag v = new Vraag("Krijg je AOW?", antwoordList);

        return situatie.data("vraag", v);
    }

    @Path("/stringpost")
    @POST
    public String lastPost(String post) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonAntwoord = """
                {
                  "antwoord": "Ja",
                  "kenmerk": "krijg AOW"
                }
                """;

//        Antwoord antwoord = mapper.readValue(new File("/src/main/resources/antwoord.json"), Antwoord.class);
        Antwoord antwoord = mapper.readValue(jsonAntwoord, Antwoord.class);

        String jsonVraag = """
                {
                                   "vraagtekst": "string0",
                                   "antwoordmogelijkheden": [
                                     {
                                       "antwoord": "string1a",
                                       "kenmerk": "string1b"
                                     },
                                     {
                                       "antwoord": "string2a",
                                       "kenmerk": "string2b"
                                     }
                                   ]
                                 }
                """;
        Vraag vraag = mapper.readValue(jsonVraag, Vraag.class);


        return post + " last";
    }

    @Path("/post")
    @POST
    public Situatie bepaalSituatie(List<Antwoord> antwoordList) {
        Situatie situatie = new Situatie("ergens", antwoordList);
        return situatie;
    }

    @Path("/vraag")
    @POST
    public void stelVraag(Vraag vraag) {
        boolean wacht=true;
    }



}
