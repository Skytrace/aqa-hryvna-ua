package gl.testing.pages.panels.bankpanels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.panels.CurrencyRatesPanelCurrencyType;
import gl.testing.utils.Utils;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$x;

public class RaiffeisenBankCurrencyRatesPanel extends CurrencyRatesPanelCurrencyType {
    private static final SelenideElement TBL_EXCHANGE_RATES = $x("//*[@id=\"bar-center\"]/div[1]//div[1]/table");
    private static final String COLUMNS_HEADERS_X_PATH = "tbody//th";
    private static final String ROWS_HEADERS_X_PATH = "tbody/tr/*[1]";
    private static final HashMap<Currency, String> CURRENCIES_MAPPER = new HashMap<>();
    private static final HashMap<Type, String> TYPES_MAPPER = new HashMap<>();
    static {
        CURRENCIES_MAPPER.put(Currency.USD, "USD");
        CURRENCIES_MAPPER.put(Currency.EUR, "Euro");

        TYPES_MAPPER.put(Type.BUY, "Buy");
        TYPES_MAPPER.put(Type.SELL, "Sell");
    }

    public HashMap<Currency, String> getCurrenciesMapper() {
        return CURRENCIES_MAPPER;
    }

    public HashMap<Type, String> getTypesMapper() {
        return TYPES_MAPPER;
    }

    public SelenideElement getExchangeRatesTable() {
        return TBL_EXCHANGE_RATES;
    }

    public String getColumnsHeadersXPath() {
        return COLUMNS_HEADERS_X_PATH;
    }

    public String getRowsHeadersXPath() {
        return ROWS_HEADERS_X_PATH;
    }

    public String getTextFromFoundCell(SelenideElement e) {
        return e.getText();
    }
}