package utilidades;

public class CreacionURL {

    public static String creaURL(String monedaBase, String monedaAConvertir, String montoParaConvertir) {
        String API_KEY = "2db617904b2f1a678b1b3f26";
        return "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaBase + "/" +  monedaAConvertir + "/" + montoParaConvertir;
    }
}
