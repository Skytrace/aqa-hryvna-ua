package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.CreditAgricoleBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class CreditAgricoleBankPage implements BankPage{
    public CreditAgricoleBankPage() {
        open("https://credit-agricole.ua/");
    }

    public CreditAgricoleBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new CreditAgricoleBankCurrencyRatesPanel();
    }
}
