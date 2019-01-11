package gl.testing.pages.panels;

import com.codeborne.selenide.SelenideElement;

public interface CurrencyRatesPanelTable extends CurrencyRatesPanel {

    SelenideElement getExchangeRatesTable();

    String getColumnsHeadersXPath();

    String getRowsHeadersXPath();

    String getTextFromFoundCell(SelenideElement table);

}
