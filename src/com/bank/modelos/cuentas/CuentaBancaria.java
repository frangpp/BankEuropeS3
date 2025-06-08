/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.modelos.cuentas;

/**
 *
 * @author franciscagoeppinger
 */
public abstract class CuentaBancaria {
    protected String numeroCuenta; 
    protected int saldo;

    public abstract boolean ingresarDinero(int monto);
    public abstract boolean retirarDinero(int monto);


    public CuentaBancaria(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.length() == 9) {
            this.numeroCuenta = numeroCuenta;
        } else {
            throw new IllegalArgumentException("El número de cuenta debe tener 9 dígitos.");
        }
        this.saldo = 0; 
        // Inicializa saldo en $0 si no se especifica
    }


    public CuentaBancaria(String numeroCuenta, int saldoInicial) {
        if (numeroCuenta != null && numeroCuenta.length() == 9) {
            this.numeroCuenta = numeroCuenta;
        } else {
            throw new IllegalArgumentException("El número de cuenta debe tener 9 dígitos.");
        }
        this.saldo = saldoInicial;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public abstract double calcularInteres();

}
