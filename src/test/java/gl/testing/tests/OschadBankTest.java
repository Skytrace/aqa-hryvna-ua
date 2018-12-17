package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.OschadBankPage;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
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
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, USD, OSCHADBANK, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, USD, OSCHADBANK, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: OschadBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        OschadBankPage oschadBankPage = new OschadBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(oschadBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(oschadBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, EUR, OSCHADBANK, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, EUR, OSCHADBANK, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }

    public BigDecimal getExpectedRate(OschadBankPage page, Currency currency, Type type) {
        return page.getCurrencyRatesPanel().getRate(currency, type);
    }
}
