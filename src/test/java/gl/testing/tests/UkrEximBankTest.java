package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.UkrEximBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.UKREXIMBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class UkrEximBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: UkrEximBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        UkrEximBankPage ukrEximBankPage = new UkrEximBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(ukrEximBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(ukrEximBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, UKREXIMBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, UKREXIMBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: UkrEximBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        UkrEximBankPage ukrEximBankPage = new UkrEximBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(ukrEximBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(ukrEximBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, UKREXIMBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, UKREXIMBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
