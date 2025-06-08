/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.bank.menu;

import com.bank.modelos.clientes.InfoCliente;
import com.bank.modelos.cuentas.CuentaAhorro;
import com.bank.modelos.cuentas.CuentaBancaria;
import com.bank.modelos.cuentas.CuentaCorriente;
import com.bank.modelos.cuentas.CuentaDigital;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankEuropeS3 {

    private ArrayList<CuentaSeleccion> cuentas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("---Bienvenido a Bank Europe---");
        System.out.println("==============================");
        BankEuropeS3 bankEurope = new BankEuropeS3();
        bankEurope.SeleccionOpciones();
    }

    public void SeleccionOpciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("Seleccione su tipo de cuenta:");
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Cuenta Digital");
        System.out.println("==============================");
        

        int tipoCuentaOpcion = 0;
        while (true) {
            try {
                System.out.println("Seleccione una opción:");
                tipoCuentaOpcion = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número. Intente nuevamente.");
                scanner.nextLine();
            }
        }

        String tipoCuenta = "";
        switch (tipoCuentaOpcion) {
            case 1 -> tipoCuenta = "Cuenta de Ahorros";
            case 2 -> tipoCuenta = "Cuenta Corriente";
            case 3 -> tipoCuenta = "Cuenta Digital";
            default -> {
                System.out.println("Opción inválida. Seleccionando Cuenta de Ahorros por defecto.");
                tipoCuenta = "Cuenta de Ahorros";
            }
        }

        
        int rut = 0;

        while (true) {
            try {
                System.out.print("Ingrese su RUT: ");
                rut = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número de RUT válido. Intente nuevamente.");
                scanner.nextLine();
            }
        }

        CuentaSeleccion cuentaSeleccionada = null;
        for (CuentaSeleccion cuenta : cuentas) {
            if (cuenta.getRut() == rut && cuenta.getTipoCuenta().equals(tipoCuenta)) {
                cuentaSeleccionada = cuenta;
                break;
            }
        }
        // Si no existe, crear la cuenta real y asociarla
        if (cuentaSeleccionada == null) {
            String numeroCuenta = String.format("%09d", rut);
            CuentaBancaria cuentaBancaria = null;
            switch (tipoCuenta) {
                case "Cuenta de Ahorros" -> cuentaBancaria = new CuentaAhorro(numeroCuenta);
                case "Cuenta Corriente" -> cuentaBancaria = new CuentaCorriente(numeroCuenta, 5000000, 0.01);
                case "Cuenta Digital" -> cuentaBancaria = new CuentaDigital(numeroCuenta, 0.01);
            }
            cuentaSeleccionada = new CuentaSeleccion(tipoCuenta, rut, cuentaBancaria);
            cuentas.add(cuentaSeleccionada);
            System.out.println("Cuenta creada y seleccionada: " + tipoCuenta + " - RUT: " + rut);
        } else {
            System.out.println("Cuenta encontrada y seleccionada: " + tipoCuenta + " - RUT: " + rut);
        }

        CuentaBancaria cuenta = cuentaSeleccionada.getCuentaBancaria();

        // Menú de operaciones
        int opcion;
        do {
            System.out.println("==============================");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Consultar datos de la cuenta");
            System.out.println("5. Salir");
            System.out.println("==============================");
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Debe ingresar un número de opción válido. Intente nuevamente.");
                    scanner.nextLine();
                }
            }
            

            switch (opcion) {
                case 1:
                    System.out.println("Depositar dinero");
                    System.out.print("Ingrese el monto que desea depositar: ");
                    int montoDeposito = scanner.nextInt();
                    if (cuenta.ingresarDinero(montoDeposito)) {
                        System.out.println("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
                    } else {
                        System.out.println("Error al depositar. Verifique el monto.");
                    }
                    break;
                case 2:
                    System.out.println("Girar dinero");
                    System.out.print("Ingrese el monto que desea retirar: ");
                    int montoRetiro = scanner.nextInt();
                    if (cuenta.retirarDinero(montoRetiro)) {
                        System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
                    } else {
                        System.out.println("No se puede retirar ese monto. Verifique su saldo o el mínimo permitido.");
                    }
                    break;
                case 3:
                    System.out.println("Consultar saldo");
                    if (cuenta instanceof CuentaAhorro) {
                        ((CuentaAhorro) cuenta).mostrarBalance();
                    } else if (cuenta instanceof CuentaCorriente) {
                        System.out.println("Saldo actual: " + cuenta.getSaldo());
                    } else if (cuenta instanceof CuentaDigital) {
                        System.out.println("Saldo actual: " + cuenta.getSaldo());
                    }
                    break;
                case 4:
                    System.out.println("Consultar datos:");
                    if (cuenta instanceof InfoCliente infoCliente) {
                        infoCliente.mostrarInformacionCliente();
                    }
                    break;

                case 5:
                    System.out.println("Gracias por usar Bank Europe. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}