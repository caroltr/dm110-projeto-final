package br.inatel.dm110.poller.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface PollerService {
	
	@GET
	@Path("/start/{IP}/{Mask}")
	@Produces(MediaType.APPLICATION_JSON)
	void setIpList(@PathParam("IP") String ip, @PathParam("Mask") String mask);
	
	@GET
	@Path("/status/{IP}")
	@Produces(MediaType.APPLICATION_JSON)
	String getStatus(@PathParam("IP") String ip);
}
