package com.fmoraes.events.resources;

import com.fmoraes.events.domain.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @GET
    public Category[] getCategories() {
        return Category.values();
    }
}
