package br.inatel.dm110.ipstatus.interfaces;

public interface IPStatus {
	
	void setIP(String ip, Integer mask);

	String getStatus(String ip);

}
