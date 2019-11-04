package coinHolder;

import java.math.BigDecimal;

public enum CoinType {
    PENNY("0.01"), NICKEL("0.05"), DIME("0.1"), QUARTER("0.25");
    private BigDecimal value;

    CoinType(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
