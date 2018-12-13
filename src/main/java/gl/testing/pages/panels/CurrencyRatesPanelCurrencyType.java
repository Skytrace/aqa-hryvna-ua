package gl.testing.pages.panels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.ParamType;
import gl.testing.pages.enums.Type;
import gl.testing.utils.Utils;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class CurrencyRatesPanelCurrencyType implements CurrencyRatesPanel {

    public abstract HashMap<Currency, String> getCurrenciesMapper();

    public abstract HashMap<Type, String> getTypesMapper();

    public BigDecimal getRate(ParamType currency, ParamType type) {
        return getRate((Currency) currency, (Type) type);
    }

    private BigDecimal getRate(Currency currency, Type type) {
        if (currency == null || type == null) {
            throw new IllegalArgumentException("Unknown currency or type.");
        }

        SelenideElement tableCell = Utils.getTableCellByHeadersNames(
                getTypesMapper().get(type),             // searched column
                getCurrenciesMapper().get(currency),    // searched row
                getExchangeRatesTable(),                // table
                getColumnsHeadersXPath(),               // relative xpath for columns header names
                getRowsHeadersXPath()                   // relative xpath for rows header names
        );

        return Utils.getNumber(getTextFromFoundCell(tableCell));
    }

}
