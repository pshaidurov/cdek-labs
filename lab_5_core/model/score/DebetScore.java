package lab_5_core.model.score;

import lab_5_core.model.account.Account;
import lab_5_core.model.constants.Constants;
import lab_5_core.model.money.Money;

public class DebetScore extends Score {
    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer
            number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override

    public void addMoney(Money money) {
        if (creditScore.getBalance().getValue() < Constants.CREDIT_LIMIT) {
            throw new IllegalArgumentException("Credit limit is over, pay credit to continue.");
        }
    }

    @Override
    protected boolean checkBefore(Money money) {
        return false;
    }

    @Override
    public Money getMoney(double balanceLess) {
        if (creditScore.getBalance().getValue() < Constants.CREDIT_LIMIT) {
            throw new IllegalArgumentException("Credit limit is over, pay credit to continue.");

        }

        return creditScore.getMoney(balanceLess);  }

    @Override
    public Money getMoneyWithoutLess() {
        return null;
    }
}