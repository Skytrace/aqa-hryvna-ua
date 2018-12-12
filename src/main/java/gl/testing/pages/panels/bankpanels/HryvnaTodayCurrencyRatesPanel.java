package gl.testing.pages.panels.bankpanels;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;
import gl.testing.pages.panels.CurrencyRatesPanelBankType;
import gl.testing.utils.Utils;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.$x;

public class HryvnaTodayCurrencyRatesPanel extends CurrencyRatesPanelBankType {
    private SelenideElement btnExpandTable = $x("//a[starts-with(@class, 'btn-light show-more-banks')]");

    private static final SelenideElement TBL_EXCHANGE_RATES = $x("//*[@id=\"banks\"]/div/table");
    private static final String COLUMNS_HEADERS_X_PATH = "thead/tr/th/div/span";
    private static final String ROWS_HEADERS_X_PATH = "tbody/tr//span[@class='banks-name']";
    private static final HashMap<Bank, String> BANKS_MAPPER = new HashMap<>();
    private static final HashMap<Type, String> TYPES_MAPPER = new HashMap<>();
    static {
        BANKS_MAPPER.put(Bank.PRIVATBANK, "ПриватБанк");
        BANKS_MAPPER.put(Bank.CREDITDNEPRBANK, "Кредит Дніпро");
        BANKS_MAPPER.put(Bank.PROCREDITBANK, "ПроКредит Банк");
        BANKS_MAPPER.put(Bank.RAIFFEIZENBANK, "Райффайзен Банк Аваль");

        TYPES_MAPPER.put(Type.BUY, "Купівля");
        TYPES_MAPPER.put(Type.SELL, "Продаж");
    }

    public HryvnaTodayCurrencyRatesPanel() {
        this.expandRatesTable();
    }

    private void expandRatesTable() {
        btnExpandTable.click();
    }


    public HashMap<Bank, String> getBanksMapper() {
        return BANKS_MAPPER;
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

    public String getTextFromFoundCell(SelenideElement table) {
        return table.$x("div//strong").text();
    }
}
