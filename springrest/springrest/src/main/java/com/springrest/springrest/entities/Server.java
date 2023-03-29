package com.springrest.springrest.entities;

public class Server {
	private long id;
	private String name;
	private String language;
	private String framework;
	
	
	public Server(long id, String name, String language, String framework) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.framework = framework;
		
	}
	public Server(long id) {
		super();
		this.id = id;
		
	}

	@Override
	public String toString() {
		return "Server [id=" + id+ ",name=" + name + ", language=" + language + ",framework=" + framework+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
		
	}
	
	
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
