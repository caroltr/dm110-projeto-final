package br.inatel.dm110.ipstatus.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.inatel.dm110.ipstatus.dao.IPStatusDAO;
import br.inatel.dm110.ipstatus.entities.IPStatus;
import br.inatel.dm110.ipstatus.util.Ping;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/IPStatusQueue"),
		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "10")
})
public class IPStatusMDB implements MessageListener {

	private static final String ACTIVE = "active";
	private static final String INACTIVE = "inactive";
	
	@EJB
	private IPStatusDAO ipStatusDAO;

	@Override
	public void onMessage(Message message) {
		
		try {
			if(message instanceof TextMessage) {
				
				TextMessage textMessage = (TextMessage) message;
				String ip = textMessage.getText();
				
				System.out.println("#### Processando mensagem: " + ip);
								
				boolean status = getStatus(ip);
				saveIPStatus(ip, status);
				
				System.out.println("#### Finalizando processamento...");
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	boolean getStatus(String ip) {
		System.out.println("Ping ip: " + ip);
		
		Ping ping = new Ping(ip);
		return ping.execPing();
	}
	
	void saveIPStatus(String ip, boolean status) {
		
		IPStatus ipStatus = new IPStatus();
        ipStatus.setIp(ip);
        ipStatus.setStatus(status ? ACTIVE : INACTIVE);
        
        ipStatusDAO.insert(ipStatus);
	}	
}
