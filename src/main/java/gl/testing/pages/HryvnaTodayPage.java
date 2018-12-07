package gl.testing.pages;

import com.codeborne.selenide.SelenideElement;
import gl.testing.pages.enums.Bank;
import gl.testing.pages.enums.Currency;
import gl.testing.pages.enums.Type;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HryvnaTodayPage {
    public SelenideElement selectorUSD = $x("//a[@href='#usd']");
    public SelenideElement selectorEUR = $x("//a[@href='#eur']");

    private static final HashMap<Type, Integer> columns = new HashMap<>();
    private static final HashMap<Bank, Integer> dataIds = new HashMap<>();

    static {
        columns.put(Type.BUY, 2);
        columns.put(Type.SELL, 3);

        dataIds.put(Bank.PRIVATBANK, 3);
        dataIds.put(Bank.RAIFFEIZENBANK, 2);
        dataIds.put(Bank.PROCREDITBANK, 12);
    }

    public HryvnaTodayPage() {
        open("https://hryvna.today");
    }

    public void chooseCurrency(Currency currency) {
        switch (currency) {
            case USD:
                this.selectorUSD.click();
                break;
            case EUR:
                this.selectorEUR.click();
                break;
            default:
                throw new IllegalArgumentException("Unknown currency.");
        }
    }

    public BigDecimal getRate(Bank bank, Type type) {
        if (bank == null || type == null) {
            throw new IllegalArgumentException("Unknown bank or type.");
        }

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
