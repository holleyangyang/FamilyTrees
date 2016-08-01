package com.demo.rabbitMq;

import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
public class Send {
	private final static String QUEUE_NAME = "hello";
	public static void main(String[] argv) throws java.io.IOException, TimeoutException {

		/* 使用工厂类建立Connection和Channel，并且设置参数 */
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");// MQ的IP
		factory.setPort(5672);// MQ端口
		factory.setUsername("guest");// MQ用户名
		factory.setPassword("guest");// MQ密码
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		/* 创建消息队列，并且发送消息 */
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!"+System.currentTimeMillis();
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		/* 关闭连接 */
		channel.close();
		connection.close();
	}
}
