package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.RaiffeisenBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class RaiffeisenBankPage {
    public RaiffeisenBankPage() {
        open("https://www.aval.ua/en/personal/everyday/exchange/exchange/");
    }

    public RaiffeisenBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new RaiffeisenBankCurrencyRatesPanel();
    }
}
