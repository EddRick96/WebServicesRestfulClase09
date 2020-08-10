package com.restful.service;

import com.restful.entidades.Personal;
import com.restful.session.PersonalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Personal")

public class PersonalRestful {
    
    @EJB
    
    private PersonalFacade personalFacade;
    
    @GET
    @Produces ({MediaType.APPLICATION_JSON})
    public List<Personal> findall(){
        return personalFacade.findAll();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Personal findByID(@PathParam("id") Integer id){
        return personalFacade.find(id);
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(Personal p){
        personalFacade.create(p);
        return Response.ok("Se ha agregado correctamente!").build(); 
    }
    
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id){
        personalFacade.remove(personalFacade.find(id));
        return Response.ok("Se ha eliminado correctamente!").build();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Personal p){
        p.setId(id);
        personalFacade.edit(p);
        return Response.ok("Se ha modificado correctamente!").build();
    }
    
}
