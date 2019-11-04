package coinHolder;

public class CoinHolderQuarter extends CoinHolder{
    private CoinType coinType;

    public CoinHolderQuarter(CoinHolder nextCoinHolder) {
        super(nextCoinHolder);
        this.coinType = CoinType.QUARTER;
    }

    public CoinType getCoinType() {
        return coinType;
    }
}
