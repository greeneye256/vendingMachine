import vendingMachine.VendingMachineImpl;

public class VendingMachineClient {

    public static void main(String[] args) {
        VendingMachineImpl vendingMachine = new VendingMachineImpl();
        vendingMachine.fillMachineWithCoins();
        vendingMachine.takeCoins(0,5,0,0);
    }

}
