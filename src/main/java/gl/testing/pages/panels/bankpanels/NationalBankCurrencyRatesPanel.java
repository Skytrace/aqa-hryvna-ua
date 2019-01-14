package gl.testing.pages.panels.bankpanels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.panels.CurrencyRatesPanelTable1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$x;

public class NationalBankCurrencyRatesPanel extends CurrencyRatesPanelTable1 {
    private SelenideElement tblExchangeRates = $x("/html/body/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div[4]/table[4]");

    private static final String COLUMNS_HEADERS_X_PATH = "tbody/tr[1]/td";
    private static final String ROWS_HEADERS_X_PATH = "tbody/tr/td[2]";
    private static final HashMap<Currency, String> CURRENCIES_MAPPER = new HashMap<>();
    private static final HashMap<Type, String> TYPES_MAPPER = new HashMap<>();

    static {
        CURRENCIES_MAPPER.put(Currency.USD, "USD");
        CURRENCIES_MAPPER.put(Currency.EUR, "EUR");

        TYPES_MAPPER.put(Type.BUY, "Офіційний курс");
        TYPES_MAPPER.put(Type.SELL, "Офіційний курс");
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
        String s = e.getText();

        return new BigDecimal(s).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP).toString();
    }
}
