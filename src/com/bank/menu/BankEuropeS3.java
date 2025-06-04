/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.bank.menu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author franciscagoeppinger
 */
public class BankEuropeS3 {

    private ArrayList<CuentaSeleccion> cuentas = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
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
        System.out.println("Seleccione una opción:");
        int tipoCuentaOpcion = scanner.nextInt();
        scanner.nextLine(); 

        String tipoCuenta = "";
        switch (tipoCuentaOpcion) {
            case 1:
                tipoCuenta = "Cuenta de Ahorros";
                break;
            case 2:
                tipoCuenta = "Cuenta Corriente";
                break;
            case 3:
                tipoCuenta = "Cuenta Digital";
                break;
            default:
                System.out.println("Opción inválida. Seleccionando Cuenta de Ahorros por defecto.");
                tipoCuenta = "Cuenta de Ahorros";
                //Para que se pueda almacenr en alguna parte 
        }

        System.out.print("Ingrese su RUT: ");
        int rut = scanner.nextInt();
        
        CuentaSeleccion cuentaSeleccion = new CuentaSeleccion(tipoCuenta, rut);
        cuentas.add(cuentaSeleccion);
        System.out.println("Cuenta seleccionada: " + cuentaSeleccion);

        //operaciones
        int opcion;
        do{
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Consultar datos de la cuenta");
            System.out.println("5. Salir");
            System.out.println("==============================");
            opcion = scanner.nextInt();
    
            switch (opcion) {
                        case 1:
                            System.out.println("Opción seleccionada: Ingresar dinero");
                            // Lógica para ingresar dinero
                            break;
                        case 2:
                            System.out.println("Opción seleccionada: Retirar dinero");
                            // Lógica para retirar dinero
                            break;
                        case 3:
                            System.out.println("Opción seleccionada: Consultar saldo");
                            // Lógica para consultar saldo
                            break;
                        case 4:
                            System.out.println("Datos de la cuenta seleccionada:");
                            System.out.println(cuentaSeleccion);
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
