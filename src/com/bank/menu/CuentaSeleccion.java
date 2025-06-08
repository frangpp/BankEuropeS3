package com.bank.menu;

import com.bank.modelos.cuentas.CuentaBancaria;


public class CuentaSeleccion {
    private String tipoCuenta;
    private int rut;
    private CuentaBancaria cuentaBancaria; 

    public CuentaSeleccion(String tipoCuenta, int rut, CuentaBancaria cuentaBancaria) {
        this.tipoCuenta = tipoCuenta;
        this.rut = rut;
        this.cuentaBancaria = cuentaBancaria;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}