package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;

import java.math.BigDecimal;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProcreditbankPage {
    private static int COL_IDX_BUY = 2;
    private static int COL_IDX_SELL = 3;
    private static int ROW_IDX_USD = 2;
    private static int ROW_IDX_EUR = 3;

    private SelenideElement rateBuyUSD = $(byXpath(getCurrencyXPath(ROW_IDX_USD, COL_IDX_BUY)));
    private SelenideElement rateSellUSD = $(byXpath(getCurrencyXPath(ROW_IDX_USD, COL_IDX_SELL)));
    private SelenideElement rateBuyEUR = $(byXpath(getCurrencyXPath(ROW_IDX_EUR, COL_IDX_BUY)));
    private SelenideElement rateSellEUR = $(byXpath(getCurrencyXPath(ROW_IDX_EUR, COL_IDX_SELL)));

    private static String getCurrencyXPath(int row, int col) {
        return String.format("//*[@id=\"currenciesContainer\"]//tr[%d]/td[%d]", row, col);
    }

    public BigDecimal getRateBuyUSD() {
        return getNumber(rateBuyUSD.text());
    }

    public BigDecimal getRateSellUSD() {
        return getNumber(rateSellUSD.text());
    }

    public BigDecimal getRateBuyEUR() {
        return getNumber(rateBuyEUR.text());
    }

    public BigDecimal getRateSellEUR() {
        return getNumber(rateSellEUR.text());
    }

    private static BigDecimal getNumber(String s) {
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to number value: " + s);
            return null;
        }
    }
}
