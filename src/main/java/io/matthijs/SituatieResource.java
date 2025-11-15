package io.matthijs;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import static java.util.Objects.requireNonNull;

@Path("/situatie")
public class SituatieResource {

    private final Template situatie;

    public SituatieResource(Template situatie)  {
        this.situatie = requireNonNull(situatie, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {

        Vraag v = new Vraag("Krijg je AOW?","Ja","Nee","Gaat je niets aan");

        return situatie.data("vraag", v);
    }

}
