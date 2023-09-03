package com.pactomais.api.exception;

public class SaldoInsuficienteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException() {
        super("Saldo insuficiente para a operação.");}
}
