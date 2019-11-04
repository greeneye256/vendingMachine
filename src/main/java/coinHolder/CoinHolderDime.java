package coinHolder;

public class CoinHolderDime extends CoinHolder{
    private CoinType coinType;

    public CoinHolderDime(CoinHolder nextCoinHolder) {
        super(nextCoinHolder);
        this.coinType = CoinType.DIME;
    }

    public CoinType getCoinType() {
        return coinType;
    }
}
