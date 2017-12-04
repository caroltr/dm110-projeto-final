package br.inatel.dm110.ipstatus.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_ip_status", sequenceName = "seq_ip_status", allocationSize = 1)
public class IPStatus {

	@Id
	private String ip;
	private String status;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
