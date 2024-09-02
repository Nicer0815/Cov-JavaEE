package consumer;



import java.util.logging.Logger;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import entity.Tube;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import jms.JMSProducer;


public final class Topic_consumer2{
	private static final Logger log = Logger.getLogger(JMSProducer.class.getName());

	
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DEFAULT_DESTINATION = "jms/topic/test";
	
	private static final String DEFAULT_USERNAME = "testqueue";
	private static final String DEFAULT_PASSWORD = "123456";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4447";
  
  

  public static void main(String[] args) throws Exception 
  {
	  Context context=null;
	  Connection connection=null;
	  ObjectMessage msg=null;
	  try {
			// ���������ĵ�JNDI����
			System.out.println("����JNDI���ʻ�����ϢҲ��������Ӧ�÷���������������Ϣ!");
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);// ��KEY��ֵΪ��ʼ��Context�Ĺ�����,JNDI����������
			env.put(Context.PROVIDER_URL,  PROVIDER_URL);// ��KEY��ֵΪContext�����ṩ�ߵ�URL.���������ṩ�ߵ�URL
			env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);//Ӧ���û��ĵ�¼��,����.
			// ��ȡ��InitialContext����.
			context = new InitialContext(env);
			System.out.println ("��ȡ���ӹ���!");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			System.out.println ("��ȡĿ�ĵ�!");
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

			// ����JMS���ӡ��Ự�������ߺ�������
			connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);		
			MessageConsumer consumer = session.createConsumer(destination);
			connection.start();
			CountDownLatch latch = new CountDownLatch(1);	
			System.out.println("��ʼ��JBOSS�˽�����Ϣ-----");
			Tube tube;
			while (true) {		
		    	msg = (ObjectMessage) consumer.receive(5000);
		        latch.await(1, TimeUnit.SECONDS);
		        if(msg != null){
		    		tube = (Tube) msg.getObject();
		    		if(tube.getState().equals("����")){
		    			break;
		    		}
		    		System.out.println("��⵽�µļ�¼:"+tube);
		        }
		        System.out.println("���ڼ�����Ƶ�ʣ�ÿ��1��......");
			 }
			for(int i = 0;i<4;i++){
				System.out.println("2�Ų���  ��  �������Լ��������ţ�" + tube.getTubeID());	
			}
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		} finally {
			if (context != null) {
				context.close();
			}
			// �ر����Ӹ���Ự,�����̺�������
			if (connection != null) {
				connection.close();
			}
		}
	}
}

