package com.springrest.springrest.controller;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Server;
import com.springrest.springrest.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@RestController			
public class MyController {
	
	@Autowired
	private ServerService serverService;
	
	@GetMapping("/home")
	public String home(){
		
		return "Welcome to server";
	}
	
	
	
	@GetMapping("/servers")
	@ResponseBody
	public List<Server> getServersRoute(@RequestParam Map<String,String> allParams) {
		System.out.println(allParams);
		if(allParams.isEmpty()) {
			System.out.println("Inside");
			return this.serverService.getServers();
		}
		List<Server>m=new ArrayList<Server>();
		for(Map.Entry<String,String> obj:allParams.entrySet()) {
			if(obj.getKey().equalsIgnoreCase("id")) {
				return this.serverService.getServerById(Long.parseLong(obj.getValue()));
			}else if(obj.getKey().equalsIgnoreCase("name")) {
				return this.serverService.getServer(obj.getValue());
			}
			 
		}
		
		return m;
	    
	}
	
	
	@PostMapping("/servers")
	public Server addServer(@RequestBody Server server) {
		return this.serverService.addServer(server);
	}
	
	@DeleteMapping("/servers")
	public Server deleteCourse(@RequestParam String id) {
		return this.serverService.deleteServer(Long.parseLong(id));
	}
	
	@PatchMapping("/servers")
	public Server updateServer(@RequestBody Map<String ,String> newServer, @RequestParam String id) {
		return this.serverService.updateServer(newServer ,Long.parseLong(id));
	}
	
	
}	