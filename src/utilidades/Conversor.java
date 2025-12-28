package utilidades;

import DTO.MonedaSeleccion;
import DTO.ResultadoConversion;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;

public class Conversor {
    private final Scanner scanner;

    public Conversor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void convertir(MonedaSeleccion seleccion) {
        System.out.println("Ingrese el monto a convertir:");
        String monto = scanner.nextLine();

        String direccion = CreacionURL.creaURL(seleccion.base, seleccion.destino, monto);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resultado de la conversión:");
            ResultadoConversion respuesta = ParseoJSON.ParseoInfo(response.body(), monto);
            System.out.println("Monto ingresado: " + monto + " " + respuesta.monedaBase() + " -> " + "Monto convertido: " +  respuesta.montoConvertido() + " " + respuesta.monedaAConvertir());
        } catch (Exception e) {
            System.out.println("Error en el llamado a la API: " + e.getMessage());
        }
    }
}
