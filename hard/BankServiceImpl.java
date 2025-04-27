package hard;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankServiceImpl implements BankService {
    @Override
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();

            Account fromAccount = session.get(Account.class, fromAccountId);
            Account toAccount = session.get(Account.class, toAccountId);

            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            session.update(fromAccount);
            session.update(toAccount);

            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            throw new RuntimeException("Transfer failed!");
        }
    }
}
