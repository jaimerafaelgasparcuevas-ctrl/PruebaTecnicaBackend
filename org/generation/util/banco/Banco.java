package org.generation.util.banco;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Banco {

    private final String nombre;
    private final Map<Integer, Cuenta> cuentas = new HashMap<>();

    public Banco(String nombre) {
        this.nombre = nombre;
    }

   
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
    }

   
    public Cuenta obtenerCuenta(int numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

  
    public boolean actualizarCuenta(int numeroCuenta, Cuenta nuevaCuenta) {
        if (!cuentas.containsKey(numeroCuenta)) return false;
        cuentas.put(numeroCuenta, nuevaCuenta);
        return true;
    }

   
    public boolean cancelarCuenta(int numeroCuenta) {
        return cuentas.remove(numeroCuenta) != null;
    }

   
    public Collection<Cuenta> getCuentas() {
        return cuentas.values();
    }

    
    public String generarReporte() {
        double totalDebito = 0;
        double totalDeudaCredito = 0;

        for (Cuenta c : cuentas.values()) {
            if (c instanceof CuentaDebito) {
                totalDebito += c.saldo;         
            } else if (c instanceof CuentaCredito) {
                totalDeudaCredito += c.saldo;   
            }
        }

        return "=== Reporte Banco: " + nombre + " ===\n"
             + "Cuentas registradas: " + cuentas.size() + "\n"
             + "Total dinero en Débito: $" + totalDebito + "\n"
             + "Total deuda en Crédito: $" + totalDeudaCredito + "\n";
    }
}
