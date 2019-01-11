package gl.testing.pages.panels;

import gl.testing.pages.enums.ParamType;

import java.math.BigDecimal;

public interface CurrencyRatesPanel {

    BigDecimal getRate(ParamType val1, ParamType val2);

}
