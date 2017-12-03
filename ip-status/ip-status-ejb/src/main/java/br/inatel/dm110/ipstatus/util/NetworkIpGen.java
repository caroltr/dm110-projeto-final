package br.inatel.dm110.ipstatus.util;

public class NetworkIpGen {
	
	private String ip;
	private int mask;
	
	/*public static void main(String[] args) {		
		ip = "192.168.1.0";
		mask = 28;
		
		for(String s : generateIps()) {
			System.out.println(s);
		}
	}*/
	
	public NetworkIpGen(String ip, String mask) {
		this.ip = ip;
		this.mask = Integer.parseInt(mask);
	}
	
	public String[] generateIps() {
		int rangeSize = 0;
		
		for (int i = 0; i < 32 - mask; i++) {
			rangeSize |= 1 << i;
		}
		
		long networkAddress = fromIp(ip);
		String[] ips = new String[rangeSize - 1];
		
		for (int i = 1; i < rangeSize; i++) {
			ips[i - 1] = toIp(networkAddress + i);
		}
		
		return ips;
	}

	private long fromIp(String ip) {
		
		String[] octs = ip.split("\\.");
		long octs1 = Long.parseLong(octs[0]);
		long octs2 = Long.parseLong(octs[1]);
		long octs3 = Long.parseLong(octs[2]);
		long octs4 = Long.parseLong(octs[3]);
		return (octs1 << 24) | (octs2 << 16) | (octs3 << 8) | octs4;
	}

	private String toIp(long value) {
		return String.format("%s.%s.%s.%s", value >> 24, (value >> 16) & 255, (value >> 8) & 255, value & 255);
	}
}
