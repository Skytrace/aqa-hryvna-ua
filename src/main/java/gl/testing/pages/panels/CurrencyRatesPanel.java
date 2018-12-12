package gl.testing.pages.panels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.ParamType;

import java.math.BigDecimal;

public interface CurrencyRatesPanel {

    BigDecimal getRate(ParamType val1, ParamType val2);


    SelenideElement getExchangeRatesTable();

    String getColumnsHeadersXPath();

    String getRowsHeadersXPath();

    String getTextFromFoundCell(SelenideElement table);
}
