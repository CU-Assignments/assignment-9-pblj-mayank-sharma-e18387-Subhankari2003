package hard;

public class TestTransaction {
    public static void main(String[] args) {
        BankService service = new BankServiceImpl();
        service.transferMoney(1, 2, 500);
    }
}
