package utilidades;

import DTO.MonedaSeleccion;
import DTO.ResultadoConversion;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParseoJSON {

    public static ResultadoConversion ParseoInfo(String informacion, String montoIngresado) {
        JsonObject obj = JsonParser.parseString(informacion).getAsJsonObject();
        String monedaBase = obj.get("base_code").getAsString();
        String monedaDestino = obj.get("target_code").getAsString();
        String montoConvertido = obj.get("conversion_result").getAsString();
        return new ResultadoConversion(monedaBase, monedaDestino, montoIngresado, montoConvertido);
    }
}
