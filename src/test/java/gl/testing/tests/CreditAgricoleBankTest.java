package gl.testing.tests;

import gl.testing.pages.CreditAgricoleBankPage;
import gl.testing.pages.HryvnaTodayPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.CREDITAGRICOLEBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class CreditAgricoleBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: CreditAgricoleBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        CreditAgricoleBankPage creditAgricoleBankPage = new CreditAgricoleBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(creditAgricoleBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(creditAgricoleBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, CREDITAGRICOLEBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, CREDITAGRICOLEBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: CreditAgricoleBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        CreditAgricoleBankPage creditAgricoleBankPage = new CreditAgricoleBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(creditAgricoleBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(creditAgricoleBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, CREDITAGRICOLEBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, CREDITAGRICOLEBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
