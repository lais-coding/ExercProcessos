package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	
	public Main() {
		super();
	}

	public static void main(String[] args) {
		
		//1 - Verificar Sistema Operacional
		
	//	RedesController r = new RedesController();
	//	String os = r.os();
	//	System.out.println("Sistema operacional nesta máquina == " +os);
		
		
		int opc = 0;
		RedesController r = new RedesController();
		
		while(opc != 3) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("\n 1 - IP \n 2 - PING \n 3 - FINALIZAR"));
			switch (opc){
			case 1:
				String ipconfig = " ";
				r.ip(ipconfig);
				break;
			case 2:
				String pingprocesso = "";
				r.ping(pingprocesso);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "FINALIZADO");
				break;
			}
					}
		
		
	
		
	}

}
