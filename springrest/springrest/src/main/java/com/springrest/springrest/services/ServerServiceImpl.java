package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Server;


@Service
public class ServerServiceImpl implements ServerService {
	//implementing ServerService interface
	
	List<Server> list;
	
	
	public ServerServiceImpl() {
		
		list = new ArrayList<Server>();
		list.add(new Server(0,"Ubuntu","Python","dJango" ));
		list.add(new Server(1,"Kali","JavaScript","NodeJS"));
		list.add(new Server(2,"Windows","Golang","C++"));
		list.add(new Server(3,"Windows","C++", "c#"));
	}
	@Override
	public List<Server> getServers() {
		
		return list;
	}
	
	@Override
	public List<Server> getServerById(long serverId) {
	
			List<Server> n;
		
			n = new ArrayList<>();
			for(Server server:list){
				
				if(server.getId()==serverId) {
					
					n.add(server);
			
				}
			}
			return n;
	}
	
	@Override
	public List<Server> getServer(String serverName) {
		List<Server> m;
		
		
		m = new ArrayList<>();
		for(Server server:list){
			
			if(serverName.equalsIgnoreCase(server.getName())) {
				
				m.add(server);
	
			}
		}
		return m;
		
	}
	
	
	
	@Override
	public Server addServer(Server server){
		for(Server obj:list) {
			if(obj.getId()==server.getId()) {
				return server;
				
			}else {
				list.add(server);
			}
			
		}
		return server;
	}
	
	@Override
	public Server deleteServer(long serverId) {
		
		
		for(Server server:list) {
			if(server.getId()==serverId) {
				
				list.remove(server);
				
			}
		}
		
		
		
		return null;
	}
	
	@Override
	public Server updateServer(Map<String ,String> newServer ,long serverId) {
		

		for(Server obj:list) {
			if(obj.getId()==serverId) {
				for(Map.Entry<String,String> entry:newServer.entrySet()) {
					if(entry.getKey().equalsIgnoreCase("name")) {
						obj.setName(entry.getValue());
					}
					if(entry.getKey().equalsIgnoreCase("language")) {
						obj.setLanguage(entry.getValue());
					}
					if(entry.getKey().equalsIgnoreCase("framework")) {
						obj.setFramework(entry.getValue());
					}
					
				}
			}
		}
		
		
		return null;
	}
	


}
