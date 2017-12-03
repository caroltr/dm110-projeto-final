package br.inatel.dm110.ipstatus.beans;

import java.util.Arrays;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import br.inatel.dm110.ipstatus.api.IPStatusListTO;
import br.inatel.dm110.ipstatus.dao.IPStatusDAO;
import br.inatel.dm110.ipstatus.entities.IPStatus;
import br.inatel.dm110.ipstatus.interfaces.IPStatusLocal;
import br.inatel.dm110.ipstatus.interfaces.IPStatusRemote;
import br.inatel.dm110.ipstatus.util.NetworkIpGen;

@Stateless
@Remote(IPStatusRemote.class)
@Local(IPStatusLocal.class)
public class IPStatusBean implements IPStatusRemote, IPStatusLocal {
	
	@EJB
	private IPStatusDAO ipStatusDAO;
	
	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/IPStatusQueue")
	private Queue queue;

	@Override
	public void setIP(String ip, String mask) {
				
		System.out.println("--- SET IP ---");
		System.out.println(ip + "/" + mask);
				
		NetworkIpGen ipGen = new NetworkIpGen(ip, mask);
		String[] ips = ipGen.generateIps();

		IPStatusListTO ipStatusListTo = new IPStatusListTO();
		ipStatusListTo.setIps(Arrays.asList(ips));
				
		try (
				Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);
		) {
			
			for(String i : ips) {
							
				TextMessage txtMessage = session.createTextMessage(i);
				producer.send(txtMessage);
			}
			
			System.out.println("Sending message");
			
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getStatus(String ip) {

		System.out.println("--- GET STATUS OF IP " + ip +" ---");
		
        for (IPStatus is : ipStatusDAO.listAll()) {
            
        	if(is.getIp().equals(ip)) {
        		return is.getStatus();
        	}
        }

        return "IP still not mapped";
	}
}
