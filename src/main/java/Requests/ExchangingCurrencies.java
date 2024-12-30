package Requests;

import DTO.ExchangeDTO;
import Models.ExchangeRequest;
import Models.ExchangeResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangingCurrencies {
    public static ExchangeResponse getExchangeConversionRate(ExchangeRequest currentExchange) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
        String apiKey = "915799893787f3a48ee6b68b";
        String baseAddress = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseAddress + "/" + currentExchange.getBaseCode() + "/" + currentExchange.getTargetCode()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ExchangeDTO exchangeDTO = gson.fromJson(response.body(), ExchangeDTO.class);
        return new ExchangeResponse(exchangeDTO);
    }

    public static String exchangeCurrenciesValue(ExchangeResponse exchangeResponse, ExchangeRequest exchangeRequest){
        double totalValueOfExchange = exchangeResponse.getConversionRate() * exchangeRequest.getValueToCalculate();

        if(exchangeRequest.getBaseCode() == null){
            return exchangeResponse.getBaseCode() + " é inválido!";
        }else if(exchangeRequest.getTargetCode() == null){
            return exchangeResponse.getTargetCode() + " é inválido!";
        }

        return String.format("O valor da conversão de " + exchangeRequest.getValueToCalculate() + " em "+ exchangeResponse.getBaseCode() + " para " + exchangeResponse.getTargetCode() + " é de " + "%.2f.", totalValueOfExchange);
    }
}
