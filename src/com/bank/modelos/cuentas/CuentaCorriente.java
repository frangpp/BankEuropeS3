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
public class CuentaCorriente extends CuentaBancaria implements InfoCliente {
    
    protected int saldoMaximo;
    protected double interes;

    public CuentaCorriente(String numeroCuenta, int saldoMaximo, double interes) {
        super(numeroCuenta);
        this.saldoMaximo = saldoMaximo;
        this.interes = interes;
    }
    
    @Override
    public boolean ingresarDinero(int monto) {
        if (monto > 0 && (saldo + monto) <= saldoMaximo) {
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

    public int getSaldoMaximo() {
        return saldoMaximo;
    }
    
    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Tipo de cuenta: Cuenta Corriente");
        System.out.println("Saldo máximo: " + getSaldoMaximo());
        System.out.println("Número de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
    }
}