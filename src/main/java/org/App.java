package org;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

public class App
{
	private static Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args)
	{
		try {
			Subscriber sub = new Subscriber();

			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						sub.client().disconnect();
					}
					catch (MqttException e) {
						logger.error(e);
						e.printStackTrace();
					}
					logger.info("Shutdown");
				}
			});

			String[] topics = {"js/test/1", "AU_2018/PLC_TwinSAFE/TcIotCommunicator/Json/Tx/Data"};

			sub.connect();
			sub.client().subscribe(topics);
		}
		catch (MqttException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

}
