package lab_5_core.model.score;

import lab_5_core.model.account.Account;
import lab_5_core.model.constants.Constants;
import lab_5_core.model.money.Money;
import lab_5_core.model.money.MoneyInterface;

public abstract class Score implements MoneyInterface {
    private Money balance;
    private Account owner;
    private Integer number;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void addMoney(Money money) {
        double usdValueIn = money.getValue() *
                money.getCurrency().getUsdCource();
        double usdValueThis = this.balance.getValue() *
                this.balance.getCurrency().getUsdCource();

        if (usdValueThis < usdValueIn) {
            System.out.println("You have no so much!");
            return;
        }


        if (checkBefore(money)) {
            this.balance.setValue((usdValueThis + usdValueIn) *
                    this.balance.getCurrency().getUsdCource());
        } else {
            System.out.println("No check!");
            return;
        }

    }

    protected abstract boolean checkBefore(Money money);

    @Override
    public Money getMoney(double balanceLess) {
        if (balanceLess > Constants.RATE_SESSION_LIMIT) {
            throw new IllegalArgumentException("You may get 30k max in session!");
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);
        return this.balance;
    }

    @Override
    public Money getMoneyWithoutLess(){
        return this.balance;
    }


}