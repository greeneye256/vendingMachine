package coinHolder;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class CoinHolder {
    private CoinHolder nextCoinHolder;
    private int numerOfCoins;
    private final int MAX_NUMBER_OF_COINS = 300;

    public CoinHolder(CoinHolder nextCoinHolder) {
        this.nextCoinHolder = nextCoinHolder;
        numerOfCoins = 0;
    }

    public CoinHolder getNextCoinHolder() {
        return nextCoinHolder;
    }

    public abstract CoinType getCoinType();

    public void fillCoinHolder() {

        this.numerOfCoins = 150;
        if (nextCoinHolder != null) {
            nextCoinHolder.fillCoinHolder();
        }
    }

    public boolean addCoins(CoinType coinType, int numerOfCoins) {
        if (coinType == getCoinType()) {
            if (this.numerOfCoins + numerOfCoins > MAX_NUMBER_OF_COINS) {
                System.out.println("Holder is full");
                return false;
            } else {
                this.numerOfCoins += numerOfCoins;
                return true;
            }
        } else {
            return nextCoinHolder.addCoins(coinType, numerOfCoins);
        }
    }

    public boolean returnChange(BigDecimal sum) {
        if (sum.equals(BigDecimal.valueOf(0))) {
            return true;
        }

        BigDecimal coinValue = getCoinType().getValue();
        int requiredCoins = sum.divide(coinValue, RoundingMode.FLOOR).intValue();
        int preparedCoins = (requiredCoins > this.numerOfCoins) ? this.numerOfCoins : requiredCoins;

        if (nextCoinHolder == null) {
            if (requiredCoins == preparedCoins) {
                if (preparedCoins != 0){
                    System.out.println(preparedCoins + " * " + coinValue.toString());
                }
                this.numerOfCoins -= preparedCoins;
                return true;
            } else return false;
        }

        if (nextCoinHolder.returnChange(sum.subtract((coinValue.multiply(BigDecimal.valueOf(preparedCoins)))))) {
            if (preparedCoins != 0){
                System.out.println(preparedCoins + " * " + coinValue.toString());
            }
            this.numerOfCoins -= preparedCoins;
            return true;
        } else {
            return false;
        }
    }
}
