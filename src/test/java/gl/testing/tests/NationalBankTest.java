package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.NationalBankPage;
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
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, NATIONALBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, NATIONALBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: NationalBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        NationalBankPage nationalBankPage = new NationalBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(nationalBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(nationalBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, NATIONALBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, NATIONALBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
