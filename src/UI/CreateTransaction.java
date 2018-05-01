package UI;

import DAO.PostgresDao;
import Models.Transaction;

/**
 * Created by Home on 5/1/18.
 */
public class CreateTransaction {
    private Transaction transaction;
    private PostgresDao pgDao;

    public CreateTransaction(Transaction transaction) {
        this.pgDao  = new PostgresDao();
        this.transaction = transaction;
        insertTransaction();
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "CreateTransaction{" +
                "transaction=" + transaction +
                '}';
    }

    public void insertTransaction() {
        String sql = "insert into library.transactions("
                + "transaction_date,"
                + "user_id,"
                + "transaction_type,"
                + "book_id"
                + ")"
                + " values ("
                + "'"
                + transaction.getTransactionDate()
                + "','"
                + transaction.getUserId()
                + "','"
                + transaction.getTransactionType()
                + "','"
                + transaction.getBookId()
                + "')";
        System.out.println("Transaction:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.insertRow(sql);
        pgDao.closeDbConnection();
    }
}
