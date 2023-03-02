package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	//1 - Verificar Sistema Operacional
	
	public String os() { //mudar para private
		String os = System.getProperty("os.name");
		return os;
	}

	//2 - IP
	
	public void ip(String ipconfig) {
		
		String os = System.getProperty("os.name");
		
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
				if(linha.contains("IPv4")) { //Verificar para retornar adaptador tambem
					System.out.println(linha);
				} linha = buffer.readLine();
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
					if(linha.contains("M�dia")){ //Tratar para exibir SOMENTE o tempo médio
						System.out.println(linha);
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
