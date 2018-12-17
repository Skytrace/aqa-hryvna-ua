package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.CreditDneprBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class CreditDneprBankPage {
    public CreditDneprBankPage() {
        open("https://creditdnepr.com.ua/en/currency");
    }

    public CreditDneprBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new CreditDneprBankCurrencyRatesPanel();
    }
}
