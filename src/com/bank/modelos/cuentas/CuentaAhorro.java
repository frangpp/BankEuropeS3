/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.modelos.cuentas;

import com.bank.modelos.clientes.InfoCliente;

/**
 *
 * @author franciscagoeppinger
 */
public class CuentaAhorro extends CuentaBancaria implements InfoCliente {

    private static final int SALDO_MINIMO = 100000;

    
    public CuentaAhorro(String numeroCuenta) {
            super(numeroCuenta, SALDO_MINIMO);
        }
    


    @Override
    public boolean ingresarDinero(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Ingreso exitoso. Nuevo saldo: " + saldo);
            return true;
        }
        return false;
    }

    @Override
    public boolean retirarDinero(int monto) {
        if (monto > 0 && (saldo - monto) >= SALDO_MINIMO) {
            saldo -= monto;
            return true;
        }
        return false; // No permite bajar de 100 lucas
    }

    @Override
    public double calcularInteres() { 
        return getSaldo() * 0.05;
        // Interés del 5% anual
    }

    public void mostrarBalance() {
        System.out.println("Saldo actual: " + saldo);
    }

    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Tipo de cuenta: Cuenta de Ahorros");
        System.out.println("Saldo mínimo: " + SALDO_MINIMO);
        System.out.println("Número de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
    }
}
