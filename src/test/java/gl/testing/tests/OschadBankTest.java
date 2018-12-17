package gl.testing.tests;

import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.OschadBankPage;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class OschadBankTest extends BasicSteps {
    @Test(description = "Exchange rate test: OschadBank vs HryvnaToday; currency: USD")
    public void testUsdExchange() {
        OschadBankPage oschadBankPage = new OschadBankPage();
        BigDecimal expectedBuyUsd = oschadBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.BUY);
        BigDecimal expectedSellUsd = oschadBankPage.getCurrencyRatesPanel().getRate(Currency.USD, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.OSCHADBANK, Type.BUY);
        BigDecimal actualSellUsd = hryvnaTodayPage.getCurrencyRatesPanel(Currency.USD).getRate(Bank.OSCHADBANK, Type.SELL);

        assertEquals(actualBuyUsd, expectedBuyUsd, "Actual rate is not as expected");
        assertEquals(actualSellUsd, expectedSellUsd, "Actual rate is not as expected");
    }

    @Test(description = "Exchange rate test: OschadBank vs HryvnaToday; currency: EUR")
    public void testEuroExchange() {
        OschadBankPage oschadBankPage = new OschadBankPage();
        BigDecimal expectedBuyEur = oschadBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.BUY);
        BigDecimal expectedSellEur = oschadBankPage.getCurrencyRatesPanel().getRate(Currency.EUR, Type.SELL);

        HryvnaTodayPage hryvnaTodayPage = new HryvnaTodayPage();
        BigDecimal actualBuyEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.OSCHADBANK, Type.BUY);
        BigDecimal actualSellEur = hryvnaTodayPage.getCurrencyRatesPanel(Currency.EUR).getRate(Bank.OSCHADBANK, Type.SELL);

        assertEquals(actualBuyEur, expectedBuyEur, "Actual rate is not as expected");
        assertEquals(actualSellEur, expectedSellEur, "Actual rate is not as expected");
    }
}
