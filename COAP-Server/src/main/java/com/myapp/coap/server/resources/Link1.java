/*******************************************************************************
 * Copyright (c) 2014 Institute for Pervasive Computing, ETH Zurich and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 * 
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *    http://www.eclipse.org/org/documents/edl-v10.html.
 * 
 * Contributors:
 *    Matthias Kovatsch - creator and main architect
 ******************************************************************************/
package com.myapp.coap.server.resources;

import org.eclipse.californium.core.CoapResource;


/**
 * This resource implements a test of specification for the ETSI IoT CoAP Plugtests, London, UK, 7--9 Mar 2014.
 */
public class Link1 extends CoapResource {

	public Link1() {
		super("link1");
		getAttributes().setTitle("Link test resource");
		getAttributes().addInterfaceDescription("If1");
		getAttributes().addResourceType("Type1");
		getAttributes().addResourceType("Type2");
	}

}
