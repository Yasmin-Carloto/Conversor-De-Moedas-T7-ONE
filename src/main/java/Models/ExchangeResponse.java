package Models;

import DTO.ExchangeDTO;

public class ExchangeResponse {
    private String baseCode;
    private String targetCode;
    private double conversionRate;

    public ExchangeResponse(ExchangeDTO exchangeDTO) {
        this.baseCode = exchangeDTO.baseCode();
        this.targetCode = exchangeDTO.targetCode();
        this.conversionRate = exchangeDTO.conversionRate();
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
