package gl.testing.pages;

import gl.testing.pages.panels.bankpanels.NationalBankCurrencyRatesPanel;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.open;

public class NationalBankPage implements BankPage {
    public NationalBankPage() {
        String today = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        open(String.format(
                "https://bank.gov.ua/control/uk/curmetal/currency/search?formType=searchFormDate" +
                "&time_step=daily&date=%s&outer=table&execute=Виконати", today)
        );
    }

    public NationalBankCurrencyRatesPanel getCurrencyRatesPanel() {
        return new NationalBankCurrencyRatesPanel();
    }
}
