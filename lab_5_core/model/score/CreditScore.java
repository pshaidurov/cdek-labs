package lab_5_core.model.score;

import lab_5_core.model.account.Account;
import lab_5_core.model.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer
            number) {
        super(balance, owner, number);




    }

    @Override
    public void addMoney(Money money) {

    }

    @Override
    protected boolean checkBefore(Money money) {
        return false;
    }

    @Override
    public Money getMoney(double balanceLess) {
        return null;
    }

    @Override
    public Money getMoneyWithoutLess() {
        return null;
    }



}