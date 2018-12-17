package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.NationalBankPage;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import static gl.testing.pages.enums.Bank.NATIONALBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class NationalBankTest extends BasicSteps {

    @Test(description = "Exchange rate test: NationalBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        NationalBankPage nationalBankPage = new NationalBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(nationalBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(nationalBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, USD, NATIONALBANK, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, USD, NATIONALBANK, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: NationalBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        NationalBankPage nationalBankPage = new NationalBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(nationalBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(nationalBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, EUR, NATIONALBANK, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, EUR, NATIONALBANK, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }

    public BigDecimal getExpectedRate(NationalBankPage page, Currency currency, Type type) {
        return page.getCurrencyRatesPanel().getRate(currency, type);
    }
}
