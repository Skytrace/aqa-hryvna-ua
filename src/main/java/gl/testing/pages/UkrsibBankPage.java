package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.UkrsibBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class UkrsibBankPage implements BankPage {
    public UkrsibBankPage() {
        open("https://my.ukrsibbank.com/ua/personal/operations/currency_exchange/");
    }

    public UkrsibBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new UkrsibBankCurrencyRatesPanel();
    }
}
