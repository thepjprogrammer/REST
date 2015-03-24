package com.thepjprogrammer.rest.inventory.brands;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.thepjprogrammer.rest.db.MySQLConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


@Path("/v1/inventory/brands") 
public class V1_Brands {

	@GET
	@Path("{brandId}")
	@Produces(MediaType.TEXT_HTML)
	public String returnName(@PathParam("brandId") int brandId) {
		
		String sqlQuery = "select * from brands where id = "+brandId;
		ResultSet productResults = null;
		String selectedBrandName = "";
		
		try
		{
			Connection dbConnection =  MySQLConnectionManager.getDatabaseConnection("inventory");
			productResults = MySQLConnectionManager.runQuery(sqlQuery, dbConnection);
			while(productResults.next())
			{
				selectedBrandName = productResults.getString("name");
			}
		}
		catch(Exception e){
			System.out.println("An error occurred");
		}
		
		return "<p>"+selectedBrandName+"</p>";
	}
	
}
