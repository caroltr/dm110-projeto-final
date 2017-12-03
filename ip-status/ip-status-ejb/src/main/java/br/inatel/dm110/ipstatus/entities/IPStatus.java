package br.inatel.dm110.ipstatus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_ip_status", sequenceName = "seq_ip_status", allocationSize = 1)
public class IPStatus {

	@Id
	@GeneratedValue(generator = "seq_ip_status", strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String ip;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
