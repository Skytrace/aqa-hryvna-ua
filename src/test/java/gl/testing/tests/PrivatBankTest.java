package gl.testing.tests;

import static gl.testing.pages.enums.Bank.PRIVATBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.PrivatBankPage;

import java.math.BigDecimal;

import org.testng.annotations.Test;

public class PrivatBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: PrivatBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        PrivatBankPage privatBankPage = new PrivatBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(privatBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(privatBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, PRIVATBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, PRIVATBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: PrivatBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        PrivatBankPage privatBankPage = new PrivatBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(privatBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(privatBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, PRIVATBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, PRIVATBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
