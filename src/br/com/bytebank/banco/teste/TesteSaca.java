package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteSaca {

	public static void main(String[] args) {
		
		ContaCorrente conta = new ContaCorrente(111, 222);
		
		conta.deposita(500);
		
		try {
			conta.saca(600);
		} catch (SaldoInsuficienteException ex) {
			System.out.println("Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}

}
