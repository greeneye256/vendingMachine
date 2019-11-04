package coinHolder;

public class CoinHolderPenny extends CoinHolder{
    private CoinType coinType;

    public CoinHolderPenny(CoinHolder nextCoinHolder) {
        super(nextCoinHolder);
        this.coinType = CoinType.PENNY;
    }

    public CoinType getCoinType() {
        return coinType;
    }
}
