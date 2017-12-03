package br.inatel.dm110.ipstatus.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.ipstatus.api.IPStatusService;
import br.inatel.dm110.ipstatus.interfaces.IPStatusRemote;

@RequestScoped
public class IPStatusImpl implements IPStatusService {

	@EJB(lookup = "java:app/ip-status-ejb-0.1-SNAPSHOT/IPStatusBean!br.inatel.dm110.ipstatus.interfaces.IPStatusRemote")
	private IPStatusRemote ipStatusBean;
	
	@Override
	public void setIP(String ip, String mask) {
		ipStatusBean.setIP(ip, mask);		
	}

	@Override
	public String getStatus(String ip) {				
		return ipStatusBean.getStatus(ip);		
	}
}
