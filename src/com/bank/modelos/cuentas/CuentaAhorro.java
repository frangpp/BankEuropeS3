/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank.modelos.cuentas;

/**
 *
 * @author franciscagoeppinger
 */
public class CuentaAhorro extends CuentaBancaria {

    
    public CuentaAhorro(String numeroCuenta) {
            super(numeroCuenta);
        }
    
        @Override
    public double calcularInteres() { 
        return getSaldo() * 0.05;
    }
}
