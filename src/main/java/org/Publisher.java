package arek.mqtt;

import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

	public static void main(String[] args) throws MqttException, InterruptedException {

		String messageString = "Hello World from Java!";

		System.out.println("== START PUBLISHER ==");

		MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
		client.connect();

		MqttMessage message = new MqttMessage();
		message.setPayload(messageString.getBytes());
		client.publish("test_data", message);
		System.out.println("\tMessage '" + messageString + "' to 'test_data'");

		TimeUnit.SECONDS.sleep(1);


		MqttMessage message2 = new MqttMessage();
		message2.setPayload(messageString.getBytes());
		client.publish("test_data2", message2);
		System.out.println("\tMessage '" + messageString + "' to 'test_data2'");

		client.disconnect();

		System.out.println("== END PUBLISHER ==");

	}

}
