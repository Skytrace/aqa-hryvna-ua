package gl.testing.pages;


import gl.testing.pages.panels.bankpanels.OtpBankCurrencyRatesPanel;

import static com.codeborne.selenide.Selenide.open;

public class OtpBankPage implements BankPage{
    public OtpBankPage() {
        open("https://www.otpbank.com.ua/");
    }

    public OtpBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new OtpBankCurrencyRatesPanel();
    }
}
