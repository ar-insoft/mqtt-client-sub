package org;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Callback implements MqttCallback
{
	private static Logger logger = LogManager.getLogger(Callback.class);

	@Override
	public void connectionLost(Throwable cause)
	{
		logger.info("connectionLost: " + cause);
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception
	{
		logger.info("messageArrived topic: " + topic + " qos: " + message.getQos() + " payload: " + new String(message.getPayload()));
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token)
	{
		logger.info("deliveryComplete token: " + token);
	}
}
