package com.business.action.self;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

import org.apache.log4j.net.SocketServer;

public class GetHttpSessionConfigurator extends Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		// TODO Auto-generated method stub
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		
		try
		{
		sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
