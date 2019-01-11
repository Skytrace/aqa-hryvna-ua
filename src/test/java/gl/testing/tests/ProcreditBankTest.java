package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.ProcreditBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.PROCREDITBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class ProcreditBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: ProcreditBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        ProcreditBankPage procreditBankPage = new ProcreditBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(procreditBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(procreditBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, PROCREDITBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, PROCREDITBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: ProcreditBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        ProcreditBankPage procreditBankPage = new ProcreditBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(procreditBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(procreditBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, PROCREDITBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, PROCREDITBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
