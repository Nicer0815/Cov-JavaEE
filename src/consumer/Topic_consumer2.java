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
			// 设置上下文的JNDI查找
			System.out.println("设置JNDI访问环境信息也就是设置应用服务器的上下文信息!");
			final Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);// 该KEY的值为初始化Context的工厂类,JNDI驱动的类名
			env.put(Context.PROVIDER_URL,  PROVIDER_URL);// 该KEY的值为Context服务提供者的URL.命名服务提供者的URL
			env.put(Context.SECURITY_PRINCIPAL, DEFAULT_USERNAME);
			env.put(Context.SECURITY_CREDENTIALS, DEFAULT_PASSWORD);//应用用户的登录名,密码.
			// 获取到InitialContext对象.
			context = new InitialContext(env);
			System.out.println ("获取连接工厂!");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);
			System.out.println ("获取目的地!");
			Destination destination = (Destination) context.lookup(DEFAULT_DESTINATION);

			// 创建JMS连接、会话、生产者和消费者
			connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);		
			MessageConsumer consumer = session.createConsumer(destination);
			connection.start();
			CountDownLatch latch = new CountDownLatch(1);	
			System.out.println("开始从JBOSS端接收信息-----");
			Tube tube;
			while (true) {		
		    	msg = (ObjectMessage) consumer.receive(5000);
		        latch.await(1, TimeUnit.SECONDS);
		        if(msg != null){
		    		tube = (Tube) msg.getObject();
		    		if(tube.getState().equals("阳性")){
		    			break;
		    		}
		    		System.out.println("检测到新的记录:"+tube);
		        }
		        System.out.println("正在监听，频率：每秒1次......");
			 }
			for(int i = 0;i<4;i++){
				System.out.println("2号部门  ，  发现阳性检测结果，编号：" + tube.getTubeID());	
			}
			
		} catch (Exception e) {
			log.severe(e.getMessage());
		} finally {
			if (context != null) {
				context.close();
			}
			// 关闭连接负责会话,生产商和消费者
			if (connection != null) {
				connection.close();
			}
		}
	}
}

