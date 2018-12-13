package gl.testing.pages;


import gl.testing.pages.panels.bankpanels.ProcreditBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class ProcreditBankPage {
    public ProcreditBankPage() {
        open("https://www.procreditbank.com.ua/currency-exchange-rates-cards/archive-exchange-rates/");
    }

    public ProcreditBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new ProcreditBankCurrencyRatesPanel();
    }
}
