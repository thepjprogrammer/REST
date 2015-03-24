package com.thepjprogrammer.rest.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;


public class CrossDomainResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext request,
			ContainerResponseContext arg1) throws IOException {
	
			MultivaluedMap<String, String> headers = request.getHeaders();
			//if you wanted it to be a completely public API
			//headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Origin", "http://localhost:8383");
			headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
			//headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
	}

}
