package br.inatel.dm110.ipstatus.interfaces;

public interface IPStatus {
	
	void setIP(String ip, String mask);

	String getStatus(String ip);

}
