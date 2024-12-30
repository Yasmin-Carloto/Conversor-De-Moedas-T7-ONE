package Models;

public class ExchangeRequest {
    private String baseCode;
    private String targetCode;
    private double valueToCalculate;
    public ExchangeRequest(String baseCode, String targetCode, double valueToCalculate) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.valueToCalculate = valueToCalculate;
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

    public double getValueToCalculate() {
        return valueToCalculate;
    }

    public void setValueToCalculate(double valueToCalculate) {
        this.valueToCalculate = valueToCalculate;
    }
}
