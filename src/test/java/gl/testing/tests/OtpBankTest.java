package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.OtpBankPage;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static gl.testing.pages.enums.Bank.OTPBANK;
import static gl.testing.pages.enums.Currency.EUR;
import static gl.testing.pages.enums.Currency.USD;
import static gl.testing.pages.enums.Type.BUY;
import static gl.testing.pages.enums.Type.SELL;
import static org.testng.Assert.assertEquals;

public class OtpBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: OtpBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        OtpBankPage otpBankPage = new OtpBankPage();
        BigDecimal expectedBuyUsd = getExpectedRate(otpBankPage, USD, BUY);
        BigDecimal expectedSellUsd = getExpectedRate(otpBankPage, USD, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = getActualRate(hryvnaTodayPage, OTPBANK, USD, BUY);
        BigDecimal actualSellUsd = getActualRate(hryvnaTodayPage, OTPBANK, USD, SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate {currency=USD, type=BUY} is not as expected;");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate {currency=USD, type=SELL} is not as expected;");
    }

    @Test(description = "Exchange rate test: OtpBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        OtpBankPage otpBankPage = new OtpBankPage();
        BigDecimal expectedBuyEur = getExpectedRate(otpBankPage, EUR, BUY);
        BigDecimal expectedSellEur = getExpectedRate(otpBankPage, EUR, SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = getActualRate(hryvnaTodayPage, OTPBANK, EUR, BUY);
        BigDecimal actualSellEur = getActualRate(hryvnaTodayPage, OTPBANK, EUR, SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate {currency=EUR, type=BUY} is not as expected;");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate {currency=EUR, type=SELL} is not as expected;");
    }
}
