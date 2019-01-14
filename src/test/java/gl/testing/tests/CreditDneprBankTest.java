package gl.testing.tests;

import gl.testing.pages.CreditDneprBankPage;
import gl.testing.pages.HryvnaTodayPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.CREDITDNEPRBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class CreditDneprBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(creditDneprBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(creditDneprBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, CREDITDNEPRBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, CREDITDNEPRBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(creditDneprBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(creditDneprBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, CREDITDNEPRBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, CREDITDNEPRBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
