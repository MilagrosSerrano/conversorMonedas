package main;

import DTO.MonedaSeleccion;
import utilidades.Conversor;
import utilidades.Menu;
import utilidades.CreacionURL;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Conversor conversor = new Conversor(scanner);

        System.out.println("¡Bienvenido al conversor de monedas!");

        String opcion = menu.mostrarMenu();

        while (!opcion.equals("0")) {
            MonedaSeleccion seleccion = menu.obtenerMonedas(opcion);

            if (seleccion != null) {
                conversor.convertir(seleccion);
            } else {
                System.out.println("Opción inválida.");
            }

            System.out.println("¿Desea realizar otra operación? (1=Sí, 0=Salir)");
            opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                opcion = menu.mostrarMenu();
            }
        }

        System.out.println("¡Gracias por utilizar nuestros servicios!");
    }
}
