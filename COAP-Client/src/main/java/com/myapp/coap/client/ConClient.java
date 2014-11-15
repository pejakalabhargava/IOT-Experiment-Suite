package com.myapp.coap.client;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.config.NetworkConfigDefaults;

public class ConClient {
	String uri = null;

	public ConClient(String uri) {
		this.uri = uri;
	}

	private void startClient() {
		// Set timer task scheduling
		Timer timer = new Timer();
		timer.schedule(new TimeTask(uri), 0, 5000);
	}

	/*
	 * Defines a new timer task to return the current time
	 */
	private class TimeTask extends TimerTask {
		String uri = null;

		public TimeTask(String uri) {
			this.uri = uri;
		}

		@Override
		public void run() {
			CoapResponse response;
			CoapClient client = new CoapClient(uri + "/obs");
			client.useCONs();
			System.out.println("client" + client);
			System.out.println("===============\nGET NONCON DATA");
			response = client.get();
			System.out.println(response.advanced().getType() + "-" + response.getCode());
			System.out.println(response.getResponseText());

		}
	}

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		if (args.length == 0) {

			System.out.println("\n IOT CoAP Client");
			System.out.println();
			System.out.println("Usage: " + PlugtestClient.class.getSimpleName() + "URI");
			System.out.println("  URI       : The CoAP URI of the Plugtest server to test (coap://...)");
			System.exit(-1);
		}

		// Config used for plugtest
		NetworkConfig.getStandard().setInt(NetworkConfigDefaults.MAX_MESSAGE_SIZE, 64).setInt(NetworkConfigDefaults.DEFAULT_BLOCK_SIZE, 64);

		int first = 0;
		String uri = args[first];

		/*
		 * if (!uri.startsWith("coap://")) { uri = "coap://" + uri; }
		 */
		if (uri.endsWith("/")) {
			uri = uri.substring(-1);
		}
		ConClient nonConClient = new ConClient(uri);
		nonConClient.startClient();
	}
}
