package mdb;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import entity.Tube;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "topic/test")
		}, 
		mappedName = "queue/test")
public class TubeMDB implements MessageListener {
	@EJB
	bean.TubeBean tubeBean;
    public void onMessage(Message inMessage) {
    	ObjectMessage msg = null;
    	System.out.println("onMessage----------------");
        try{
        	if(inMessage instanceof ObjectMessage){
        		msg = (ObjectMessage)inMessage;
        		Tube tube = (Tube) msg.getObject();
        		System.out.println("MDB==:tube:"+tube+"==>TubeBean");
        		tubeBean.updateTube(tube);
        	}else{
        		System.out.println("消息类型不正确："+inMessage.getClass().getName());

        	}
        }catch(JMSException e){
        	e.printStackTrace();
        }catch(Throwable e){
        	e.printStackTrace();
        }
    }

}