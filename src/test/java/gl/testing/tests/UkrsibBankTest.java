package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.UkrsibBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.UKRSIBBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class UkrsibBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: UkrsibBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        UkrsibBankPage ukrsibBankPage = new UkrsibBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(ukrsibBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(ukrsibBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, UKRSIBBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, UKRSIBBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: UkrsibBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        UkrsibBankPage ukrsibBankPage = new UkrsibBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(ukrsibBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(ukrsibBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, UKRSIBBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, UKRSIBBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
