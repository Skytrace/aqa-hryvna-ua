package gl.testing.pages;

import static com.codeborne.selenide.Selenide.open;

import gl.testing.pages.panels.bankpanels.PrivatBankCurrencyRatesPanel;

public class PrivatBankPage implements BankPage {
    public PrivatBankPage() {
        open("https://privatbank.ua");
    }

    public PrivatBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new PrivatBankCurrencyRatesPanel();
    }
}
