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

@Path("/events")
public class EventResource {

    @Inject
    private EventService eventService;

    @GET
    @Path("/{id}")
    public Event findById(@PathParam("id") Long id) {
        return this.eventService.find(id);
    }

    @POST
    public Response create(@Valid Event event, @Context UriInfo uriInfo) {
        var id = this.eventService.create(event);
        var location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(id)).build();
        return Response.created(location).build();
    }
}
