package br.com.marcos.jogodaforca;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static void iniciar(String[] lista, Scanner scanner) {
		Scanner sc = scanner;
		char letra;
		String[] listaPalavras = lista;
		Random gerador = new Random();
		JogoDaForca partida = new JogoDaForca(listaPalavras[gerador.nextInt(listaPalavras.length)]);
		
		System.out.println("\n\t\t\tJOGO DA FORCA!");
		
		boolean fim = false;
		do {
			
			System.out.println("\n\n\nErros: "+partida.obterErros()+"/6\n");
			System.out.print("Progresso: "+partida.obterProgresso()+"\t\t\tDigite uma letra: ");
			
			letra = sc.next().charAt(0);
			
			partida.jogada(letra);
			
			if((partida.obterErros() == 6) || (partida.estaCompleto())) {
				fim = true;
			}
		} while(!fim);
		
		if(partida.obterErros() == 6) {
			System.out.println("\t\t\tVOCE PERDEU!!!!\n\n");
			System.out.println("\t\t\tA palavra era: "+partida.obterPalavraAlvo());
		} else if(partida.estaCompleto()) {
			System.out.println("\t\t\tPARABÉNS VOCE GANHOU!!!!\n\n");
		}
		
	}
	
		
	
	public static void main(String[] args) {
		char op = 'n';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\t\t\tDESEJA JOGAR UMA PARTIDA DE FORCA?(s/n):");
		
		op = sc.next().charAt(0);
		String[] listaPalavras = {"universidade", "federal", "ensino", "computacao", "ciencias","superior"};
		
		while(op != 'n') {
			iniciar(listaPalavras, sc);
			System.out.print("\t\t\tDESEJA JOGAR MAIS UMA PARTIDA DE FORCA?(s/n):");

			op = sc.next().charAt(0);
		}
		
		System.out.println("\t\t\tPROGRAMA FINALIZADO.");
		sc.close();
	}
}
