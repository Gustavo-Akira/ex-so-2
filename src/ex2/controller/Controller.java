package ex2.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Controller {
	
	public String getOS() {
		return System.getProperty("os.name");
	}
	
	public String getAllProcess(String so) throws IOException{
		String command = "";
		StringBuilder result = new StringBuilder();
		if(so.contains("Windows")) {
			command = "tasklist";
		}else {
			command = "ps";	
		}
		String x = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));
		while ((x = br.readLine()) != null) {
			result.append(x+"\n");
		}
		br.close();
		return result.toString();
	}
	
	public void killProcessById(String so, String pid) throws IOException {
		String command = "";
		if(so.contains("Windows")) {
			command = "taskkill /F /PID "+pid;
		}else {
			command = "kill -9 "+pid;	
		}
		Runtime.getRuntime().exec(command);
	}
	
	public void killProccessByName(String so,String name) throws IOException {
		String command = "";
		if(so.contains("Windows")) {
			command = "taskkill /IM "+name + " /F";
		}else {
			command = "kill -9 "+name;	
		}
		Runtime.getRuntime().exec(command);
	}
}
