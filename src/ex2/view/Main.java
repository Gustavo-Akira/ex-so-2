package ex2.view;

import java.io.IOException;
import java.util.Scanner;

import ex2.controller.Controller;

public class Main {
	
	private final static Controller controller = new Controller();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		while(x == 0) {
			System.out.println(" 1- View Processes \n 2- kill process by PID \n 3- kill process by name \n Qualquer outro numero você termina o programa");
			int y = sc.nextInt();
			switch(y) {
			case 1:
				System.out.println(controller.getAllProcess(controller.getOS()));
				break;
			case 2:
				System.out.println("digite o pid");
				String pid = sc.next();
				controller.killProcessById(controller.getOS(), pid);
				System.out.println("deletado com sucesso");
				break;
			case 3:
				System.out.println("digite o name");
				String name = sc.next();
				controller.killProcessById(controller.getOS(), name);
				System.out.println("deletado com sucesso");
				break;
			default:
				x=1;
				break;
			}
		}
		sc.close();
	}

}
