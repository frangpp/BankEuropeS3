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

    

    @Override
    public void mostrarInformacionCliente() {
        System.out.println("Número de cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
    }
    
}
