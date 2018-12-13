package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.OschadBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.*;

public class OschadBankPage {
    public OschadBankPage() {
        open("https://www.oschadbank.ua/ua/");
    }

    public OschadBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new OschadBankCurrencyRatesPanel();
    }
}
