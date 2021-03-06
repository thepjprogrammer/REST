package com.thepjprogrammer.rest.inventory.products;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.thepjprogrammer.rest.db.MySQLConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


@Path("/v1/inventory/products") 
public class V1_Products {

	@GET
	@Path("{productId}")
	@Produces(MediaType.TEXT_HTML)
	public String returnName(@PathParam("productId") int productId) {
		
		String sqlQuery = "select * from products where id = "+productId;
		ResultSet productResults = null;
		String selectedProductName = "";
		
		try
		{
			Connection dbConnection =  MySQLConnectionManager.getDatabaseConnection("inventory");
			productResults = MySQLConnectionManager.runQuery(sqlQuery, dbConnection);
			while(productResults.next())
			{
				selectedProductName = productResults.getString("name");
			}
		}
		catch(Exception e){
			System.out.println("An error occurred");
		}
		
		return "<p>"+selectedProductName+"</p>";
	}
	
}
