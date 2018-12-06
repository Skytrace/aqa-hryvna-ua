package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class PrivatbankPage {
    private SelenideElement rateBuyUSD = $(byId("USD_buy"));
    private SelenideElement rateSellUSD = $(byId("USD_sell"));
    private SelenideElement rateBuyEUR = $(byId("EUR_buy"));
    private SelenideElement rateSellEUR = $(byId("EUR_sell"));

    public BigDecimal getRate(Currency currency, Type type) {
        switch (currency) {
            case USD:
                switch (type) {
                    case BUY:
                        return getNumber(rateBuyUSD.text());
                    case SELL:
                        return getNumber(rateSellUSD.text());
                }
            case EUR:
                switch (type) {
                    case BUY:
                        return getNumber(rateBuyEUR.text());
                    case SELL:
                        return getNumber(rateSellEUR.text());
                }
        }

        return null;
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
