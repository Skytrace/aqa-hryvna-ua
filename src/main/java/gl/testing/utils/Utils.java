package gl.testing.utils;

import com.codeborne.selenide.SelenideElement;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static BigDecimal getNumber(String s) {
        try {
            return new BigDecimal(s).setScale(4, RoundingMode.DOWN);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to number value: " + s);
            return null;
        }
    }

    public synchronized static SelenideElement getTableCellByHeadersNames(String searchedColumn, String searchedRow, SelenideElement table,
                                                             String columnsHeadersXPath, String rowsHeadersXPath) {

        List<String> columnsHeadersNamesList = collectHeaderNamesToList(table, columnsHeadersXPath);
        List<String> rowsHeadersNamesList = collectHeaderNamesToList(table, rowsHeadersXPath);

        if (!columnsHeadersNamesList.contains(searchedColumn)) {
            throw new IllegalArgumentException("Missing \"" + searchedColumn + "\" value in columns headers.");
        }

        if (!rowsHeadersNamesList.contains(searchedRow)) {
            throw new IllegalArgumentException("Missing \"" + searchedRow + "\" value in rows headers.");
        }

        String xpath = String.format("tbody/tr[%d]/td[%d]",
                rowsHeadersNamesList.indexOf(searchedRow) + 1,
                columnsHeadersNamesList.indexOf(searchedColumn) + 1);

        return table.$x(xpath);
    }

    private static ArrayList<String> collectHeaderNamesToList(SelenideElement table, String headersXpath) {
        List<String> headersNamesList = table.$$x(headersXpath)
                .stream()
                .map(SelenideElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        return (ArrayList<String>) headersNamesList;
    }
}
