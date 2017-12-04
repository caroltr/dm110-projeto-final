package br.inatel.dm110.ipstatus.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface IPStatusService {
	
	@GET
	@Path("/start/{ip}/{mask}")
	@Produces(MediaType.TEXT_PLAIN)
	String setIP(@PathParam("ip") String ip, @PathParam("mask") Integer mask);
	
	@GET
	@Path("/status/{ip}")
	@Produces(MediaType.TEXT_PLAIN)
	String getStatus(@PathParam("ip") String ip);

}
