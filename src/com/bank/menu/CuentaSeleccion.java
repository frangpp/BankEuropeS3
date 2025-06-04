package com.bank.menu;

public class CuentaSeleccion {
    private String tipoCuenta;
    private int rut;

    public CuentaSeleccion(String tipoCuenta, int rut) {
        this.tipoCuenta = tipoCuenta;
        this.rut = rut;
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

    @Override
    public String toString() {
        return "Tipo de Cuenta: " + tipoCuenta + ", RUT: " + rut;
    }
}
