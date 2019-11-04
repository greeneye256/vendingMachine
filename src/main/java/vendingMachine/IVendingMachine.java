package vendingMachine;

import Item.Item;

public interface IVendingMachine {
    void takeCoins(int pennies, int nickels, int dimes, int quarters);
    boolean returnChange(double change);
    void fillMachineWithCoins();
    void addItemToVendingMachine(Integer key, Item item);
    void selectItem(int key);
}
