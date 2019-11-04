package coinHolder;

public class CoinHolderNickel extends CoinHolder{
    private CoinType coinType;

    public CoinHolderNickel(CoinHolder nextCoinHolder) {
        super(nextCoinHolder);
        this.coinType = CoinType.NICKEL;
    }

    public CoinType getCoinType() {
        return coinType;
    }
}
