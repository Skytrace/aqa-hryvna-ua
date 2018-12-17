package gl.testing.tests;

import gl.testing.pages.CreditDneprBankPage;
import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CreditDneprBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyUsd = creditDneprBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.BUY);
        BigDecimal expectedSellUsd = creditDneprBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.CREDITDNEPRBANK, Type.BUY);
        BigDecimal actualSellUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.CREDITDNEPRBANK, Type.SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: CreditDneprBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        CreditDneprBankPage creditDneprBankPage = new CreditDneprBankPage();
        BigDecimal expectedBuyEur = creditDneprBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.BUY);
        BigDecimal expectedSellEur = creditDneprBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.CREDITDNEPRBANK, Type.BUY);
        BigDecimal actualSellEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.CREDITDNEPRBANK, Type.SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }
}
