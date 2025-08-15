package br.com.iniflex.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class UtilFormatacao {
    private static final Locale PT_BR = new Locale("pt","BR");
    private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance(PT_BR);

    public String moeda(BigDecimal v) {
        return CURRENCY.format(v);
    }
}