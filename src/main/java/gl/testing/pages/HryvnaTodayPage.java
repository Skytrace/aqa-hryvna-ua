package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.panels.bankpanels.HryvnaTodayCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.*;

public class HryvnaTodayPage {
    private SelenideElement btnUsdCurrency = $x("//a[@href='#usd']");
    private SelenideElement btnEurCurrency = $x("//a[@href='#eur']");

    public HryvnaTodayPage() {
        open("https://hryvna.today");
    }

    public HryvnaTodayCurrencyRatesPanel getCurrencyRatesPanel(Currency currency) {
        chooseCurrency(currency);
        return new HryvnaTodayCurrencyRatesPanel();
    }

    private void chooseCurrency(Currency currency) {
        switch (currency) {
            case USD:
                this.btnUsdCurrency.click();
                break;
            case EUR:
                this.btnEurCurrency.click();
                break;
            default:
                throw new IllegalArgumentException("Unknown currency.");
        }
    }

}
