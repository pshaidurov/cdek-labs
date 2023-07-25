package lab_5_core.model.score;

import lab_5_core.model.account.Account;
import lab_5_core.model.constants.Constants;
import lab_5_core.model.money.Money;

public class CurrentScore extends Score {
    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer
            number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;

    }

    @Override
    public void addMoney(Money money) {

        double usdValueIn = money.getValue() *
                money.getCurrency().getUsdCource();
        double usdValueThis = getBalance().getValue() *
                getBalance().getCurrency().getUsdCource();

        if (usdValueIn > Constants.SUMM_UP_FOR_BONUS) {
            getBalance().setValue(usdValueThis + Constants.BOUNS_SIZE + usdValueIn);
            return;
        }


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