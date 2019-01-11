package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.OschadBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.OSCHADBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class OschadBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: OschadBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        OschadBankPage oschadBankPage = new OschadBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(oschadBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(oschadBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, OSCHADBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, OSCHADBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: OschadBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        OschadBankPage oschadBankPage = new OschadBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(oschadBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(oschadBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, OSCHADBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, OSCHADBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
