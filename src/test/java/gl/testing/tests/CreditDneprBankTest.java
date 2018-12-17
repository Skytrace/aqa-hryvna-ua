package gl.testing.tests;

import gl.testing.pages.CreditDneprBankPage;
import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CreditDneprBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(creditDneprBankPage, Currency.USD, Type.BUY);
        BigDecimal expectedSellUsd = getExpectedRate(creditDneprBankPage, Currency.USD, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, Currency.USD,Bank.CREDITDNEPRBANK, Type.BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, Currency.USD, Bank.CREDITDNEPRBANK, Type.SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(creditDneprBankPage, Currency.EUR, Type.BUY);
        BigDecimal expectedSellEur = getExpectedRate(creditDneprBankPage, Currency.EUR, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, Currency.EUR, Bank.CREDITDNEPRBANK, Type.BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, Currency.EUR, Bank.CREDITDNEPRBANK, Type.SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }

    public BigDecimal getExpectedRate(CreditDneprBankPage page, Currency currency, Type type) {
        return page.getCurrencyRatesPanel().getRate(currency, type);
    }
}
