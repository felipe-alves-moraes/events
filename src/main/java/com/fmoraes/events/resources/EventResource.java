package com.fmoraes.events.resources;

import com.fmoraes.events.application.EventService;
import com.fmoraes.events.domain.Event;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Optional;

@Path("/events")
public class EventResource {

    @Inject
    private EventService eventService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Optional.ofNullable(this.eventService.find(id))
            .map(Response::ok)
            .orElse(Response.status(Response.Status.NOT_FOUND))
            .build();
    }

    @POST
    public Response create(@Valid Event event, @Context UriInfo uriInfo) {
        Long id = this.eventService.create(event);
        URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(location).build();
    }
}
