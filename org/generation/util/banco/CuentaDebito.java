package org.generation.util.banco;

import java.util.Date;

public class CuentaDebito extends Cuenta {

    private double montoMinimo;

    // OJO: este orden debe coincidir con SimulaBanco:
    // new CuentaDebito(2000, "D8001", fecha, 1000, "Juan Pérez")
    public CuentaDebito(double saldo, String numeroCliente, Date fechaApertura,
                        double montoMinimo, String nombreCliente) {
        super(saldo, numeroCliente, fechaApertura, nombreCliente);
        this.montoMinimo = montoMinimo;
    }

    public double getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(double montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public double retiro(double cantidad) {
        if (cantidad <= 0) return getSaldo();

        if (this.saldo >= cantidad) {
            setSaldo(this.saldo - cantidad);
        }
        return getSaldo();
    }

    @Override
    public double deposito(double cantidad) {
        if (cantidad <= 0) return getSaldo();

        setSaldo(this.saldo + cantidad);
        return getSaldo();
    }

    @Override
    public String toString() {
        return "Cuenta Débito [" + super.toString()
                + ", Monto mínimo=" + montoMinimo + "]";
    }
}