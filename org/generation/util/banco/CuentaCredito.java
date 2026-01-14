package org.generation.util.banco;

import java.util.Date;

public class CuentaCredito extends Cuenta {

    private double limite;
    private float tasa;
    private Date fechaCorte;
    private Date fechaLimitePago;

    public CuentaCredito(double saldo, String numeroCliente,
                          Date fechaCorte, Date fechaLimitePago,
                          float tasa, double limite, String nombreCliente) {

        
        super(saldo, numeroCliente, fechaCorte, nombreCliente);
        this.fechaCorte = fechaCorte;
        this.fechaLimitePago = fechaLimitePago;
        this.tasa = tasa;
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Date getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(Date fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    @Override
    public double getSaldo() {
        
        setSaldo(this.saldo + 3);
        return this.saldo;
    }

    @Override
    public double retiro(double cantidad) {
        if (cantidad <= 0) return this.saldo;

        
        double disponible = this.limite - this.saldo;

        if (disponible >= cantidad) {
            double comision = cantidad * 0.05;
            setSaldo(this.saldo + cantidad + comision);
        } else {
            
            setSaldo(this.saldo + 5);
        }
        return this.saldo;
    }

    @Override
    public double deposito(double cantidad) {
        if (cantidad <= 0) return this.saldo;

        
        setSaldo(Math.max(0, this.saldo - cantidad));
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Cuenta Crédito [" + super.toString()
                + " Tasa=" + getTasa() + "%, Límite=" + getLimite() + "]";
    }
}