package io.matthijs.resources;

import io.matthijs.models.Antwoord;
import io.matthijs.models.Situatie;
import io.matthijs.models.Vraag;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Path("/situatie")
public class SituatieResource {

    private final Template situatie;

    public SituatieResource(Template situatie)  {
        this.situatie = requireNonNull(situatie, "page is required");
    }

    @Path("/get")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        Vraag v = new Vraag("Krijg je AOW?","Ja","Nee","Gaat je niets aan");

        return situatie.data("vraag", v);
    }

    @Path("/stringpost")
    @POST
    public String lastPost(String post) {
        return post + " last";
    }

    @Path("/post")
    @POST
    public Situatie bepaalSituatie(List<Antwoord> antwoordList) {
        Situatie situatie = new Situatie("ergens", antwoordList);
        return situatie;
    }



}
