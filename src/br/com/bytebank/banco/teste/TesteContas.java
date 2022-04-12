
public class TesteContas {

	public static void main(String[] args) throws SaldoInsuficienteException {
					
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);
		
		try {
			cc.transfere(110.0, cp);
		} catch (SaldoInsuficienteException ex) {
			System.out.println("Erro na transferência (Saldo insuficiente) " + ex.getMessage());
		}
		
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
	}

}