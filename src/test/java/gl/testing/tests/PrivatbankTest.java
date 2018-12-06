package gl.testing.tests;

import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.HryvnatodayPage;
import gl.testing.pages.PrivatbankPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class PrivatbankTest {
    @Test
    public void testUsdExchange() {
        HryvnatodayPage hp = new HryvnatodayPage();
        hp.chooseCurrency(Currency.USD);
        BigDecimal rateHryvnatodayBuyUsd = hp.getRate(Bank.PRIVATBANK, Type.BUY);
        BigDecimal rateHryvnatodaySellUsd = hp.getRate(Bank.PRIVATBANK, Type.SELL);

        PrivatbankPage pp = new PrivatbankPage();
        BigDecimal ratePrivatbankBuyUsd = pp.getRate(Currency.USD, Type.BUY);
        BigDecimal ratePrivatbankSellUsd = pp.getRate(Currency.USD, Type.SELL);

        Assert.assertEquals(rateHryvnatodayBuyUsd, ratePrivatbankBuyUsd);
        Assert.assertEquals(rateHryvnatodaySellUsd, ratePrivatbankSellUsd);
    }

    @Test
    public void testEuroExchange() {
        HryvnatodayPage hp = new HryvnatodayPage();
        hp.chooseCurrency(Currency.EUR);
        BigDecimal rateHryvnatodayBuyEur = hp.getRate(Bank.PRIVATBANK, Type.BUY);
        BigDecimal rateHryvnatodaySellEur = hp.getRate(Bank.PRIVATBANK, Type.SELL);

        PrivatbankPage pp = new PrivatbankPage();
        BigDecimal ratePrivatbankBuyEur = pp.getRate(Currency.EUR, Type.BUY);
        BigDecimal ratePrivatbankSellEur = pp.getRate(Currency.EUR, Type.SELL);

        Assert.assertEquals(rateHryvnatodayBuyEur, ratePrivatbankBuyEur);
        Assert.assertEquals(rateHryvnatodaySellEur, ratePrivatbankSellEur);
    }
}
