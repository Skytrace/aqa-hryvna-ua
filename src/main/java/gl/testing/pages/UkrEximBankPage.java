package gl.testing.pages;


import gl.testing.pages.panels.bankpanels.UkrEximBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class UkrEximBankPage implements BankPage {
    public UkrEximBankPage() {
        open("https://www.eximb.com/ukr/personal/everyday/currency_exchange/?f=personal");
    }

    public UkrEximBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new UkrEximBankCurrencyRatesPanel();
    }
}
