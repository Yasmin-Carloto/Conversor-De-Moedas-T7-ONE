import Models.ExchangeRequest;
import Models.ExchangeResponse;
import Requests.ExchangingCurrencies;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Digite a moeda de base para conversão: Ex: converter REAL para dólar. Digite 'sair' para sair");
            String baseCode = scanner.nextLine();

            if(baseCode.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Digite a moeda de alvo para conversão: Ex: converter de real para DÓLAR");
            String targetCode = scanner.nextLine();

            System.out.println("Digite o valor da conversâo: ");
            double valueToConvert = scanner.nextDouble();

            scanner.nextLine();

            try {
                ExchangeRequest exchangeRequest = new ExchangeRequest(baseCode.toUpperCase(), targetCode.toUpperCase(), valueToConvert);
                ExchangeResponse exchangeResponse = ExchangingCurrencies.getExchangeConversionRate(exchangeRequest);

                System.out.println(ExchangingCurrencies.exchangeCurrenciesValue(exchangeResponse, exchangeRequest));
            }catch (Exception e){
                System.out.println("As informações fornecidas estão inválidas. Cheque as informações e tente novamente.");
            }
        }
    }
}
