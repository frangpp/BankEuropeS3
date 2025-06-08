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
public class CuentaDigital extends CuentaBancaria implements InfoCliente {
    private double interes;
    
    public CuentaDigital(String numeroCuenta, double interes) {
        super(numeroCuenta);
        this.interes = interes;
    }

    @Override
    public boolean ingresarDinero(int monto) {
        if (monto > 0) {
            saldo += monto;
            return true;
        }
        return false;
    }

    @Override
    public boolean retirarDinero(int monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    @Override
    public double calcularInteres() {
        //interés 1% anual
        return saldo * 0.01;
    }
    
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Tipo de cuenta: Cuenta Digital");
        System.out.println("Interés: " + interes);
        System.out.println("Número de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
    }

}
