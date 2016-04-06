package br.com.luizalexandrew.socketrelatorio;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerRelatorio {

	private static ServerSocket server;

	public static void main(String[] args) throws Exception {

		server = new ServerSocket(5000);

		while (true) {
			Socket socket = server.accept();
			PrintWriter writeClient = new PrintWriter(socket.getOutputStream());
			Scanner entrada = new Scanner(socket.getInputStream());
			Grafico grafico = new Grafico();
			
			writeClient.println("Conectado");
			writeClient.flush();		
			
			grafico.criarLinhasMarcadoras(entrada.nextLine());
			grafico.gerarGrafico();
			
			try {
				while (true) {
					grafico.adicionaValorGrafico(entrada.nextLine());
					
				}
			} catch (Exception e) {
				System.out.println("Finalizando o grafico");
			} finally {
				entrada.close();
				writeClient.close();
			}

		}

	}

}
