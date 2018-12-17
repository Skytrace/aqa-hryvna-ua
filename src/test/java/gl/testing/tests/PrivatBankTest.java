package gl.testing.tests;

import static org.testng.Assert.assertEquals;

import gl.testing.pages.HryvnaTodayPage;
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
        BigDecimal expectedBuyUsd = privatBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.BUY);
        BigDecimal expectedSellUsd = privatBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.PRIVATBANK, Type.BUY);
        BigDecimal actualSellUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.PRIVATBANK, Type.SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: PrivatBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        PrivatBankPage privatBankPage = new PrivatBankPage();
        BigDecimal expectedBuyEur = privatBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.BUY);
        BigDecimal expectedSellEur = privatBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.PRIVATBANK, Type.BUY);
        BigDecimal actualSellEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.PRIVATBANK, Type.SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }
}
