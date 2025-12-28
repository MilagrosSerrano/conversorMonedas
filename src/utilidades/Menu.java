package utilidades;

import DTO.MonedaSeleccion;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public String mostrarMenu() {
        String opciones = """
                Por favor ingrese que operación desea realizar:
                1. Dolar -> Peso Argentino
                2. Peso Argentino -> Dolar
                3. Dolar -> Real Brasileño
                4. Real Brasileño -> Dolar
                5. Peso Colombiano -> Dolar
                6. Dolar -> Peso Colombiano
                0. Salir
                """;
        System.out.println(opciones);
        return scanner.nextLine();
    }

    public MonedaSeleccion obtenerMonedas(String opcion) {
        return switch (opcion) {
            case "1" -> new MonedaSeleccion("USD", "ARS");
            case "2" -> new MonedaSeleccion("ARS", "USD");
            case "3" -> new MonedaSeleccion("USD", "BRL");
            case "4" -> new MonedaSeleccion("BRL", "USD");
            case "5" -> new MonedaSeleccion("COP", "USD");
            case "6" -> new MonedaSeleccion("USD", "COP");
            default -> null;
        };
    }
}
