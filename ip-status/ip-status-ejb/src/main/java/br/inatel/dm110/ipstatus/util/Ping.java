package br.inatel.dm110.ipstatus.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ping {
	
	private String ip;
	
	/*public static void main(String[] args) {		
		ip = "192.168.0.102";		
		System.out.println(execPing());
	}*/
		
	public Ping(String ip) {
		this.ip = ip;
	}
	
	public boolean execPing() {
		try {
			
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("ping -n 1 " + ip);
			InputStream is = process.getInputStream();
			InputStream es = process.getErrorStream();
			String input = processStream(is);
			String error = processStream(es);
			int code = process.waitFor();
			
			if (code != 0) {
				return false;
			}
						
			if (error.length() > 0) {
				return false;
			}
						
			if (input.contains("Host de destino inacess")) {
				return false;
			}
						
			return true;
			
		} catch (IOException | InterruptedException e) {
			return false;
		}
	}
	
	private static String processStream(InputStream is) {
				
		StringBuilder input = new StringBuilder();
		try (Scanner scanner = new Scanner(is)) {
			while (scanner.hasNextLine()) {
				input.append(scanner.nextLine()).append("\n");
			}
		}
		
		return input.toString();
	}
}
