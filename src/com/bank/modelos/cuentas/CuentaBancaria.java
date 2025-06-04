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
    private String numeroCuenta; 
    private int saldo;
    
    public CuentaBancaria(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.length() == 10) {
            this.numeroCuenta = numeroCuenta;
        } else {
            throw new IllegalArgumentException("El número de cuenta debe tener 9 dígitos.");
        }
    }

    public CuentaBancaria(String numeroCuenta, int saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public abstract double calcularInteres();
}
