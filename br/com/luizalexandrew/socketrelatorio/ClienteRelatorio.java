package br.com.luizalexandrew.socketrelatorio;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteRelatorio {

	private static Socket socket;

	public static void main(String[] args) throws Exception {

		socket = new Socket("127.0.0.1", 5000);
		Scanner s = new Scanner(socket.getInputStream());
		System.out.println(s.nextLine());
		Scanner teclado = new Scanner(System.in);
		PrintWriter w = new PrintWriter(socket.getOutputStream());
		Double n1;
		w.println("Grafico de Temperatura,Segundos,Temperatura");
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Digite um valor: ");
			n1 = (Double) teclado.nextDouble();
			w.println(formatar(n1, "Exaustor", i));
			w.flush();
		}

		teclado.close();
		w.close();
		s.close();

	}

	public static String formatar(Double n1, String item, int tempo) {
		return n1 + "," + item + "," + tempo;
	}

}
