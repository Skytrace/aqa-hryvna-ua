package gl.testing.tests;

import static gl.testing.pages.enums.Bank.PRIVATBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.OschadBankPage;
import gl.testing.pages.PrivatBankPage;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;

import java.math.BigDecimal;

import org.testng.annotations.Test;

public class PrivatBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: PrivatBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        PrivatBankPage privatBankPage = new PrivatBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(privatBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(privatBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, USD, PRIVATBANK, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, USD, PRIVATBANK, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: PrivatBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        PrivatBankPage privatBankPage = new PrivatBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(privatBankPage, Currency.EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(privatBankPage, Currency.EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, EUR, PRIVATBANK, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, EUR, PRIVATBANK, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }

    public BigDecimal getExpectedRate(PrivatBankPage page, Currency currency, Type type) {
        return page.getCurrencyRatesPanel().getRate(currency, type);
    }
}
