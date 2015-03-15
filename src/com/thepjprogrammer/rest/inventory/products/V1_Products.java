package com.thepjprogrammer.rest.inventory.products;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/v1/inventory/products") 
public class V1_Products {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnName() {
		return "<p>Some Product Name</p>";
	}
	
}
