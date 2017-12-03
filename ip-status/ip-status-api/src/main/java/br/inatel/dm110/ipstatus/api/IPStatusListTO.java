package br.inatel.dm110.ipstatus.api;

import java.io.Serializable;
import java.util.List;

public class IPStatusListTO implements Serializable {

	private static final long serialVersionUID = -1837765522549229605L;
	
	private List<String> ips;

	public List<String> getIps() {
		return ips;
	}

	public void setIps(List<String> list) {
		this.ips = list;
	}	
}
