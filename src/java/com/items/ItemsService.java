/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.items;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ahmad
 */
@Path("/itemservice")
public class ItemsService {
    ItemDao itemsDao = new ItemDao();

    @GET
    @Path("/itemsList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> displayItems() {
        
        return itemsDao.getAllItemsList();
        
    }

    @POST
    @Path("/addItem")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmployee(Item item) {

        int id, price;
        String name;

        id = item.getId();
        name = item.getName();
        price = item.getPrice();
        String result = "Item saved : " + "id= " + id + " name= " + name  + "Price= " + price;

       //return Response.status(201).entity(result).build();
         return itemsDao.addItem(id, name, price);

    }
}
