package gl.testing.pages.panels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.ParamType;
import gl.testing.pages.enums.Type;
import gl.testing.utils.Utils;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class CurrencyRatesPanelBankType implements CurrencyRatesPanel {

    public abstract HashMap<Bank, String> getBanksMapper();

    public abstract HashMap<Type, String> getTypesMapper();

    public BigDecimal getRate(ParamType bank, ParamType type) {
        return getRate((Bank) bank, (Type) type);
    }

    public BigDecimal getRate(Bank bank, Type type) {
        if (bank == null || type == null) {
            throw new IllegalArgumentException("Unknown bank or type.");
        }

        SelenideElement tableCell = Utils.getTableCellByHeadersNames(
                getTypesMapper().get(type),             // searched column
                getBanksMapper().get(bank),             // searched row
                getExchangeRatesTable(),                // table
                getColumnsHeadersXPath(),               // relative xpath for columns header names
                getRowsHeadersXPath()                   // relative xpath for rows header names
        );

        return Utils.getNumber(getTextFromFoundCell(tableCell));
    }


}
