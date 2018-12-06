package gl.testing.tests;

import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.HryvnatodayPage;
import gl.testing.pages.PrivatbankPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selenide.open;

public class PrivatbankTest {
    private static HryvnatodayPage hryvnatodayPage;
    private static PrivatbankPage privatbankPage;


    @Test
    public void test1_privatbank() {

        open("https://hryvna.today");
        hryvnatodayPage = new HryvnatodayPage();
        chooseCurrency(Currency.USD);
        BigDecimal hryvnatodayPage_BUY_USD =
                hryvnatodayPage.getRate(Bank.PRIVATBANK, Type.BUY);
        chooseCurrency(Currency.EUR);
        BigDecimal hryvnatodayPage_SELL_USD =
                hryvnatodayPage.getRate(Bank.PRIVATBANK, Type.SELL);

        open("https://privatbank.ua");
        privatbankPage = new PrivatbankPage();
        BigDecimal privatbank_BUY_USD = privatbankPage.getRate(Currency.USD, Type.BUY);
        BigDecimal privatbank_SELL_USD = privatbankPage.getRate(Currency.EUR, Type.SELL);

        Assert.assertEquals(hryvnatodayPage_BUY_USD, privatbank_BUY_USD);
        Assert.assertEquals(hryvnatodayPage_SELL_USD, privatbank_SELL_USD);
    }

    private static void chooseCurrency(Currency currency) {
        switch (currency) {
            case USD:
                hryvnatodayPage.selectorUSD.click();
                break;
            case EUR:
                hryvnatodayPage.selectorEUR.click();
                break;
        }
    }
}
