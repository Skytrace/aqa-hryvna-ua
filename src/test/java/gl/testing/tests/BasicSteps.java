package gl.testing.tests;

import com.codeborne.selenide.Configuration;
import gl.testing.pages.BankPage;
import gl.testing.pages.HryvnaTodayPage;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import java.math.BigDecimal;
import org.testng.annotations.BeforeClass;

public class BasicSteps {

    @BeforeClass
    public void setUpChromeConfiguration() {
        Configuration.startMaximized = true;
    }

    public BigDecimal getActualRate(HryvnaTodayPage hryvnaPage, Bank bank, Currency currency, Type type) {
        return hryvnaPage.getCurrencyRatesPanel(currency).getRate(bank, type);
    }

    public BigDecimal getExpectedRate(BankPage page, Currency currency, Type type) {
        return page.getCurrencyRatesPanel().getRate(currency, type);
    }
}
