package vendingMachine;

import Item.Item;
import coinHolder.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class VendingMachineImpl implements IVendingMachine{

    private CoinHolder maxCoinHolder;
    private int[] receivedCoins = {0,0,0,0};
    private Map<Integer, Queue<Item>> vendingMachineItems = new HashMap<>();
    private final int MAX_ITEMS = 9;
    private final int MAX_NUMBER_OF_ITEMS = 10;

    private void initializeMap(){
        for (int i = 1; i < 10; i++) {
            vendingMachineItems.put(i,null);
        }
    }

    public VendingMachineImpl() {
        CoinHolder tempCoinHolder = null;
        tempCoinHolder = new CoinHolderPenny(tempCoinHolder);
        tempCoinHolder = new CoinHolderNickel(tempCoinHolder);
        tempCoinHolder = new CoinHolderDime(tempCoinHolder);
        tempCoinHolder = new CoinHolderQuarter(tempCoinHolder);
        maxCoinHolder = tempCoinHolder;
    }

    public int[] getReceivedCoins() {
        return receivedCoins;
    }

    public void takeCoins(int pennies, int nickels, int dimes, int quarters) {

//
        receivedCoins[0] = pennies;
        receivedCoins[1] = nickels;
        receivedCoins[2] = dimes;
        receivedCoins[3] = quarters;
    }

    private void acceptCoins(int[] coins){
        maxCoinHolder.addCoins(CoinType.PENNY, coins[0]);
        maxCoinHolder.addCoins(CoinType.NICKEL, coins[1]);
        maxCoinHolder.addCoins(CoinType.DIME, coins[2]);
        maxCoinHolder.addCoins(CoinType.QUARTER, coins[3]);
    }

    public boolean returnChange(double change) {
        if (change == 0){
            System.out.println("Have a nice day.");
            return true;
        }
        else return maxCoinHolder.returnChange(BigDecimal.valueOf(change));
    }

    public void fillMachineWithCoins() {
        maxCoinHolder.fillCoinHolder();
    }

    @Override
    public void addItemToVendingMachine(Integer key, Item item) {
        ArrayBlockingQueue<Item> items = new ArrayBlockingQueue<Item>(MAX_NUMBER_OF_ITEMS);
        for (int i = 0; i < MAX_NUMBER_OF_ITEMS; i++) {
            items.add(item);
        }
        vendingMachineItems.put(key,items);
    }

    @Override
    public void selectItem(int key) {
        vendingMachineItems.get(key).
    }

    public void printChoices(){
        System.out.println("WELCOME!\n\n");
        System.out.println("Select product:\n");
    }
}
