package com.springrest.springrest.services;

import java.util.List;
import java.util.Map;

import com.springrest.springrest.entities.Server;

public interface ServerService {

	public List<Server> getServers();
	
	public List<Server> getServerById(long serverId);
	
	public List<Server> getServer(String serverName);
	
	public Server addServer(Server server);

	public Server deleteServer(long serverId);

	public Server updateServer(Map<String ,String> newServer,long serverId);
}
