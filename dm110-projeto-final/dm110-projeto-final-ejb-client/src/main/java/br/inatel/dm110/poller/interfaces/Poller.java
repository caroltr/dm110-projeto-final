package br.inatel.dm110.poller.interfaces;

public interface Poller {

	void setIpList(String ip, String mask);
	
	String getStatus(String ip);
}
