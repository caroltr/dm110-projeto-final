package br.inatel.dm110.poller.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.poller.api.PollerService;
import br.inatel.dm110.poller.interfaces.PollerRemote;

@RequestScoped
public class PollerServiceImpl implements PollerService {

	@EJB(lookup = "java:app/dm110-ejb-0.1-SNAPSHOT/InventoryBean!br.inatel.dm110.hello.interfaces.InventoryRemote") // TODO get real lookup
	private PollerRemote inventoryBean;
	
	@Override
	public void setIpList(String ip, String mask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStatus(String ip) {
		// TODO Auto-generated method stub
		return null;
	}

}
