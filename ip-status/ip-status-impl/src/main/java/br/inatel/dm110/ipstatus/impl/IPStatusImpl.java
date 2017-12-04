package br.inatel.dm110.ipstatus.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import org.apache.commons.validator.routines.InetAddressValidator;

import br.inatel.dm110.ipstatus.api.IPStatusService;
import br.inatel.dm110.ipstatus.interfaces.IPStatusRemote;

@RequestScoped
public class IPStatusImpl implements IPStatusService {

	@EJB(lookup = "java:app/ip-status-ejb-0.1-SNAPSHOT/IPStatusBean!br.inatel.dm110.ipstatus.interfaces.IPStatusRemote")
	private IPStatusRemote ipStatusBean;
	
	@Override
	public String setIP(String ip, Integer mask) {

		if(isIpValid(ip) && isMaskValid(mask)) {		
			ipStatusBean.setIP(ip, mask);
			
			return "Validação do status dos IPs iniciado.";
		} else {
			return "Entrada inválida!";
		}
	}

	@Override
	public String getStatus(String ip) {
		if(isIpValid(ip)) {		
			return ipStatusBean.getStatus(ip);	
		} else {
			return "Entrada inválida!";
		}			
	}
	
	private boolean isIpValid(String ip) {
		return InetAddressValidator.getInstance().isValidInet4Address(ip);
	}
	
	private boolean isMaskValid(Integer mask) {
		return (mask >= 8 && mask <= 30);
	}
	
}
