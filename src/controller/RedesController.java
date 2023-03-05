package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	//1 - Verificar Sistema Operacional
	
	
	private String os() { 
		String os = System.getProperty("os.name");
		return os;
	}

	//2 - IP
	
	public void ip(String ipconfig) {
		
		String os = System.getProperty("os.name");
		String[] nomeAdaptador = new String[0];
	
		if(os.contains("Windows")) {
			ipconfig = "IPCONFIG";
		}
		
		else if(os.contains("Linux")) {
			ipconfig = "IFCONFIG";
		}
		
		try {
			Process config = Runtime.getRuntime().exec(ipconfig);
			InputStream dados = config.getInputStream();
			InputStreamReader ler = new InputStreamReader(dados);
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			while (linha != null) {
				
				if(linha.contains("Adaptador")) {
					nomeAdaptador = linha.split(":");
					
				} 
				if (linha.contains("IPv4")) {
					String[] enderecoip = linha.split(":");
					System.out.println(Arrays.toString(nomeAdaptador));
					System.out.println(Arrays.toString(enderecoip));
				}
				
				
				linha = buffer.readLine();
			}
			
			buffer.close();
			ler.close();
			dados.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		//3 - PING
		
		public void ping(String pingprocesso) {
			
			String os = System.getProperty("os.name");
			String [] media = new String [0];
			
			
			if(os.contains("Windows")) {
				pingprocesso = "PING -4 -n 10 www.google.com.br";
			}
			
			else if(os.contains("Linux")) {
				pingprocesso = "PING -4 -c 10 www.google.com.br";
			}
			
			try {
				Process chamar = Runtime.getRuntime().exec(pingprocesso);
				InputStream dados = chamar.getInputStream();
				InputStreamReader ler = new InputStreamReader(dados);
				BufferedReader buffer = new BufferedReader(ler);
				String linha = buffer.readLine();
				
				while(linha != null) {
				
					if(linha.contains("M�dia")) {
						media = linha.split(",");
						System.out.println((media[2]));
					}
						
					
					linha = buffer.readLine();
				}
				
				buffer.close();
				ler.close();
				dados.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		
	}
	
	
}
