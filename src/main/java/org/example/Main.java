package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer rolAcceso = 0;
        Integer opcion = 0;
        Integer opcionVerInfo = 0;
        Integer indiceGlobal = 0;
        Integer horasTrabajadasEspecialista = 0;
        String[] especialistas = new String[100];
        Integer[] cedulaEspecialistas = new Integer[100];
        String[] especialidad = new String[100];
        Double[] salarioEspecialistas = new Double[100];
        String[] fechaIngresos = new String[100];

        System.out.println("¡BIENVENIDO A SPECIAL SOLUTIONS SURA S.A.!");

        while (rolAcceso != 4) {
            System.out.println("Digita tu rol: 1. Administrador 2. Especialista 3. Paciente 4. Salir");
            rolAcceso = scanner.nextInt();

            if (rolAcceso == 1) {
                while (opcion != 3) {
                    System.out.println("OPCIONES DE ADMINISTRADOR: ");
                    System.out.println("1. Registrar informacion de especialistas ");
                    System.out.println("2. Ingresar a base de datos especialistas ");
                    System.out.println("3. Salir");
                    System.out.print("Digita una opcion: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.print("Digita el nombre del especialista: ");
                            scanner.nextLine();
                            especialistas[indiceGlobal] = scanner.nextLine();
                            System.out.print("Digita el numero de cedula: ");
                            cedulaEspecialistas[indiceGlobal] = scanner.nextInt();
                            System.out.print("Digita la especialidad: ");
                            especialidad[indiceGlobal] = scanner.next();
                            System.out.print("Digita el salario del especialista: ");
                            salarioEspecialistas[indiceGlobal] = scanner.nextDouble();
                            System.out.print("Digita la fecha de ingreso del especialista: ");
                            fechaIngresos[indiceGlobal] = scanner.next();
                            indiceGlobal++;
                            break;
                        case 2:
                            while (opcionVerInfo != 4) {
                                System.out.println("1. Ver informacion especialistas");
                                System.out.println("2. Buscar especialista por numero de cedula");
                                System.out.println("3. Retirar especialista por numero de cedula");
                                System.out.println("4. Salir");
                                System.out.print("Digita una opcion: ");
                                opcionVerInfo = scanner.nextInt();

                                switch (opcionVerInfo) {
                                    case 1:
                                        System.out.println("ESPECIALISTAS:");
                                        System.out.println("Nombre            | Cedula         | Especialidad   | Salario       | Fecha Ingreso");
                                        for (int indice = 0; indice < indiceGlobal; indice++) {
                                            String formattedLine = String.format("%-18s%-16s%-16s%-15s%s",
                                                    especialistas[indice],
                                                    cedulaEspecialistas[indice],
                                                    especialidad[indice],
                                                    salarioEspecialistas[indice],
                                                    fechaIngresos[indice]
                                            );
                                            System.out.println(formattedLine);
                                        }
                                        break;
                                    case 2:
                                        System.out.print("NUMERO DE CEDULA ESPECIALISTA: ");
                                        int buscarPorCedula = scanner.nextInt();
                                        int indiceEncontrado = -1;
                                        for (int indice = 0; indice < indiceGlobal; indice++) {
                                            if (cedulaEspecialistas[indice] == buscarPorCedula) {
                                                indiceEncontrado = indice;
                                                break;
                                            }
                                        }
                                        if (indiceEncontrado != -1) {
                                            System.out.println("ESPECIALISTA ENCONTRADO:");
                                            System.out.println("Nombre: " + especialistas[indiceEncontrado]);
                                            System.out.println("Cedula: " + cedulaEspecialistas[indiceEncontrado]);
                                            System.out.println("Especialidad: " + especialidad[indiceEncontrado]);
                                            System.out.println("Salario: " + salarioEspecialistas[indiceEncontrado]);
                                            System.out.println("Fecha Ingreso: " + fechaIngresos[indiceEncontrado]);
                                        } else {
                                            System.out.println("ESPECIALISTA NO ENCONTRADO");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("NUMERO DE CEDULA DE ESPECIALISTA QUE DESEA RETIRAR: ");
                                        int retirarCedula = scanner.nextInt();
                                        int indiceEncontrado2 = -1;
                                        for (int indice = 0; indice < indiceGlobal; indice++) {
                                            if (cedulaEspecialistas[indice] == retirarCedula) {
                                                indiceEncontrado2 = indice;
                                                break;
                                            }
                                        }
                                        if (indiceEncontrado2 != -1) {
                                            for (int indice = indiceEncontrado2; indice < indiceGlobal - 1; indice++) {
                                                especialistas[indice] = especialistas[indice + 1];
                                                cedulaEspecialistas[indice] = cedulaEspecialistas[indice + 1];
                                                especialidad[indice] = especialidad[indice + 1];
                                                salarioEspecialistas[indice] = salarioEspecialistas[indice + 1];
                                                fechaIngresos[indice] = fechaIngresos[indice + 1];
                                            }
                                            especialistas[indiceGlobal - 1] = null;
                                            cedulaEspecialistas[indiceGlobal - 1] = null;
                                            especialidad[indiceGlobal - 1] = null;
                                            salarioEspecialistas[indiceGlobal - 1] = null;
                                            fechaIngresos[indiceGlobal - 1] = null;
                                            indiceGlobal--;

                                            System.out.println("ESPECIALISTA RETIRADO CORRECTAMENTE");
                                        } else {
                                            System.out.println("EL ESPECIALISTA QUE DESEA RETIRAR NO SE HA ENCONTRADO");
                                        }
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        System.out.println("Opcion invalida");
                                }
                            }
                            opcionVerInfo = 0;
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                }
                opcion = 0;
            } else if (rolAcceso == 2) {
                while (opcion != 4) {
                    System.out.println("OPCIONES DE ESPECIALISTA: ");
                    System.out.println("1. Reportar el numero de horas trabajadas en un mes");
                    System.out.println("2. Consultar salario mensual");
                    System.out.println("3. Ver base de datos especialistas");
                    System.out.println("4. Salir");
                    System.out.print("Digita una opcion: ");
                    opcion = scanner.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingresa el numero de horas trabajadas en un mes: ");
                            horasTrabajadasEspecialista = scanner.nextInt();
                            break;
                        case 2:
                            Double salarioPorHora = 150000.0;
                            Double salario = horasTrabajadasEspecialista * salarioPorHora;
                            Double retencionSalario = salario * 0.04;
                            Double salarioMensual = salario - retencionSalario;
                            System.out.println("Tu salario mensual es de: $" + salarioMensual);
                            break;
                        case 3:
                            System.out.println("ESPECIALISTAS:");
                            System.out.println("Nombre            | Cedula      | Especialidad   | Fecha Ingreso");
                            for (int indice = 0; indice < indiceGlobal; indice++) {
                                String formattedLine = String.format("%-18s%-14s%-16s%s",
                                        especialistas[indice],
                                        cedulaEspecialistas[indice],
                                        especialidad[indice],
                                        fechaIngresos[indice]
                                );
                                System.out.println(formattedLine);
                            }
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                }
                opcion = 0;
            } else if (rolAcceso == 3) {
                while (opcion != 2) {
                    System.out.println("OPCIONES DE PACIENTE: ");
                    System.out.println("1. Ver base de datos especialistas");
                    System.out.println("2. Salir");
                    System.out.print("Digita una opcion: ");
                    opcion = scanner.nextInt();

                    switch (opcion){
                        case 1:
                            System.out.println("BASE DE DATOS ESPECIALISTAS:");
                            System.out.println("Nombre            | Cedula      | Especialidad");
                            for (int indice = 0; indice < indiceGlobal; indice++) {
                                String formattedLine = String.format("%-18s%-14s%-16s",
                                        especialistas[indice],
                                        cedulaEspecialistas[indice],
                                        especialidad[indice]
                                );
                                System.out.println(formattedLine);
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                }
                opcion = 0;
            } else {
                System.out.println("Rol invalido");
            }
        }
        System.out.println("Hasta luego, Vuelva pronto");
    }
}