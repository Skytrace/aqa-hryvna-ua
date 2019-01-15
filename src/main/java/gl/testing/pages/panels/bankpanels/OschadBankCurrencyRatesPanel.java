package gl.testing.pages.panels.bankpanels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.ParamType;
import gl.testing.pages.enums.Type;
import gl.testing.pages.panels.CurrencyRatesPanel;
import gl.testing.pages.panels.CurrencyRatesPanelTable1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$x;

public class OschadBankCurrencyRatesPanel implements CurrencyRatesPanel {
    private static final HashMap<String, String> LOCATORS_MAPPER = new HashMap<>();

    static {
        LOCATORS_MAPPER.put("USD_BUY", "buy-USD");
        LOCATORS_MAPPER.put("USD_SELL", "sell-USD");
        LOCATORS_MAPPER.put("EUR_BUY", "buy-EUR");
        LOCATORS_MAPPER.put("EUR_SELL", "sell-EUR");
    }

    public BigDecimal getRate(Currency currency, Type type) {
        SelenideElement rate = $x(String.format("//strong[@class='%s']", LOCATORS_MAPPER.get(currency + "_" + type)));

        return new BigDecimal(rate.text().replace(",", ".")).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getRate(ParamType currency, ParamType type) {
        return getRate((Currency) currency, (Type) type);
    }
}
