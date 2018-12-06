package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Type;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HryvnatodayPage {
    public SelenideElement selectorUSD = $(byXpath("//div[1]//div[2]/div[1]/div[2]//li[1]/a"));
    public SelenideElement selectorEUR = $(byXpath("//div[1]//div[2]/div[1]/div[2]//li[2]/a"));

    private static final HashMap<Type, Integer> columns = new HashMap<>();
    private static final HashMap<Bank, Integer> dataIds = new HashMap<>();

    static {
        columns.put(Type.BUY, 2);
        columns.put(Type.SELL, 3);

        dataIds.put(Bank.PRIVATBANK, 3);
        dataIds.put(Bank.RAIFFEIZENBANK, 2);
        dataIds.put(Bank.PROCREDITBANK, 12);
    }

    public BigDecimal getRate(Bank bank, Type type) {
        return getRateFromPage(dataIds.get(bank), columns.get(type));
    }

    private static BigDecimal getRateFromPage(int dataId, int column) {
        return getNumber($(byXpath(getCurrencyXPath(dataId, column))).text());
    }

    private static String getCurrencyXPath(int dataId, int col) {
        return String.format("//*[@id=\"banks\"]/div/table/tbody/tr[@data-id=%d]/td[%d]//strong", dataId, col);
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