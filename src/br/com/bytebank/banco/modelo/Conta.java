package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta no projeto ByteBank
 * 
 * @author Taiuã Nascimento
 * @version 0.1
 */

public abstract class Conta {

    protected double saldo; //o modificador de acesso torna o atributo visivel apenas para as classes filhas
    private int agencia;
    private int numero;
    private Cliente titular;
    
    /**
     * Construtor para inicializar o objeto Conta a partir da agencia e numero.
     * 
     * @param agencia
     * @param numero
     */
    public Conta(int agencia, int numero){
        if (agencia < 1) {
        	throw new IllegalArgumentException("Agencia inválida!");
        } this.agencia = agencia;
        
        if (numero < 1) {
        	throw new IllegalArgumentException("Número da conta inválido");
        } this.numero = numero;
        
        
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita(double valor);

    /**
     * Valor precisa ser maior que o saldo.
     * 
     * @param valor
     * @throws SaldoInsuficienteException
     */
    public void saca(double valor) throws SaldoInsuficienteException {
        if(this.saldo < valor) {
        	throw new SaldoInsuficienteException("Saldo: " + this.saldo + " | Valor: " + valor);
        } this.saldo -= valor;
    }

    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
    	this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        if(numero <= 0) {
            System.out.println("Nao pode valor menor igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia(){
        return this.agencia;
    }

    public void setAgencia(int agencia){
       if(agencia <= 0) {
           System.out.println("Nao pode valor menor igual a 0");
           return;
       }
       this.agencia = agencia;
    }

    public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public Cliente getTitular(){
        return this.titular;
    }
}