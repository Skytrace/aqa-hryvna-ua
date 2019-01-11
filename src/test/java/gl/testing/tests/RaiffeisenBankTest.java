package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.RaiffeisenBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.RAIFFEIZENBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class RaiffeisenBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: RaiffeisenBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        RaiffeisenBankPage raiffeisenBankPage = new RaiffeisenBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(raiffeisenBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(raiffeisenBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, RAIFFEIZENBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, RAIFFEIZENBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: RaiffeisenBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        RaiffeisenBankPage raiffeisenBankPage = new RaiffeisenBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(raiffeisenBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(raiffeisenBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, RAIFFEIZENBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, RAIFFEIZENBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
