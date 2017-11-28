package br.inatel.dm110.poller.beans;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import br.inatel.dm110.poller.interfaces.PollerLocal;
import br.inatel.dm110.poller.interfaces.PollerRemote;

@Stateless
@Remote(PollerRemote.class)
@Local(PollerLocal.class)
public class PollerBean implements PollerRemote, PollerLocal {

	//@EJB
	//private ProductDAO productDAO;

	@Resource(lookup = "java:/ConnectionFactory") // TODO reconfigure
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/productQueue") // TODO reconfigure
	private Queue queue;
	
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
