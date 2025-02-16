package core.entrada;

import java.util.Scanner;

public class GestorEntrada {
    Scanner scanner = new Scanner(System.in);

    public GestorEntrada() {
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            System.out.print(mensaje);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, introduce un número válido.");
            System.out.print(mensaje);
            scanner.next();
        }
        return scanner.nextDouble();
    }
}


