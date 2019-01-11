package gl.testing.pages.panels.bankpanels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.panels.CurrencyRatesPanelTable1;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$x;

public class UkrsibBankCurrencyRatesPanel extends CurrencyRatesPanelTable1 {
    private SelenideElement tblExchangeRates = $x("//table[@class='currency__table']");

    private static final String COLUMNS_HEADERS_X_PATH = "thead//td";
    private static final String ROWS_HEADERS_X_PATH = "tbody//td[1]";
    private static final HashMap<Currency, String> CURRENCIES_MAPPER = new HashMap<>();
    private static final HashMap<Type, String> TYPES_MAPPER = new HashMap<>();

    static {
        CURRENCIES_MAPPER.put(Currency.USD, "USD, долар США");
        CURRENCIES_MAPPER.put(Currency.EUR, "EUR, євро");

        TYPES_MAPPER.put(Type.BUY, "КУПІВЛЯ");
        TYPES_MAPPER.put(Type.SELL, "ПРОДАЖ");
    }

    public HashMap<Currency, String> getCurrenciesMapper() {
        return CURRENCIES_MAPPER;
    }

    public HashMap<Type, String> getTypesMapper() {
        return TYPES_MAPPER;
    }

    public SelenideElement getExchangeRatesTable() {
        return tblExchangeRates;
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
