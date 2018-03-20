package br.com.marcos.jogodaforca;

public class JogoDaForca {

	private String palavraAlvo;
	private char[] progresso;
	private int erros;
	
	JogoDaForca(String palavraDada) {
		palavraAlvo = palavraDada;
		progresso = new char[palavraAlvo.length()];
		for(int i = 0; i < progresso.length; i++) {
			progresso[i] = '_';
		}
		erros = 0;
	}
	
	private boolean consultarProgresso(char letra) {
		boolean resultado = false;
		if(progresso.length > 0) {
			for(char c: progresso) {
				if(c == letra) {
					resultado = true;
					break;
				}
			}
		}
		return resultado;
	}
	
	private boolean consultarPalavraAlvo(char letra) {
		boolean resultado = false;
			for(int i = 0; i < palavraAlvo.length(); i++) {
				if(palavraAlvo.charAt(i) == letra) {
					resultado = true;
					break;
				}
			}
		return resultado;
	}
	
	private void avancar(char letra) {
		for(int i = 0; i < palavraAlvo.length(); i++) {
			if(palavraAlvo.charAt(i) == letra) {
				progresso[i] = letra;
			}
		}
	}
	
	boolean jogada(char letra) {
		boolean resultado = false;
		if(consultarPalavraAlvo(letra)) {
			resultado = true;
			if(!consultarProgresso(letra)) {
				avancar(letra);
			}
		} else {
			erros++;
		}
		return resultado;
	}
	
	boolean estaCompleto() {
		boolean resultado = true;
		for(int i = 0; i < progresso.length; i++) {
			if(progresso[i] != palavraAlvo.charAt(i)) {
				resultado = false;
				break;
			}
		}
		return resultado;
	}
	
	String obterPalavraAlvo() {
		return this.palavraAlvo;
	}
	
	String obterProgresso() {
		String progresso = new String(this.progresso);
		return progresso;
	}
	
	int obterErros() {
		return this.erros;
	}
}
