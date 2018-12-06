package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PrivatbankPage {
    private SelenideElement rateBuyUSD = $(byId("USD_buy"));
    private SelenideElement rateSellUSD = $(byId("USD_sell"));
    private SelenideElement rateBuyEUR = $(byId("EUR_buy"));
    private SelenideElement rateSellEUR = $(byId("EUR_sell"));

    public PrivatbankPage() {
        open("https://privatbank.ua");
    }

    public BigDecimal getRate(Currency currency, Type type) {
        if (currency == Currency.USD && type == Type.BUY) {
            return getNumber(rateBuyUSD.text());
        } else if (currency == Currency.USD && type == Type.SELL) {
            return getNumber(rateSellUSD.text());
        } else if (currency == Currency.EUR && type == Type.BUY) {
            return getNumber(rateBuyEUR.text());
        } else if (currency == Currency.EUR && type == Type.SELL) {
            return getNumber(rateSellEUR.text());
        } else {
            throw new IllegalArgumentException("Unknown currency or type.");
        }
    }

    private static BigDecimal getNumber(String s) {
        try {
            return new BigDecimal(s).setScale(4, RoundingMode.DOWN);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to number value: " + s);
            return null;
        }
    }
}
