package org.generation.util;

public class TarjetaRegalo implements Imprimible {

    private int numeroCuenta;
    private double saldo;

    public TarjetaRegalo(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public double deposito(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
        return saldo;
    }

    public double retiro(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
        }
        return saldo;
    }
}
