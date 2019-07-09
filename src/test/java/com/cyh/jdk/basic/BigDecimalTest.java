package com.cyh.jdk.basic;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author 陈奕鸿
 * @Description
 * @Date 创建于 19-7-8 下午5:46
 */
public class BigDecimalTest {

    /**
     *  调用BigDecimal自带的方法去掉小数部分多余的零
     */
    @Test
    public void removeDecimalZeroTest1() {
        BigDecimal a = new BigDecimal("600.00");
        assertEquals("600", a.stripTrailingZeros().toPlainString());

        BigDecimal b = new BigDecimal("600.00100");
        assertEquals("600.001", b.stripTrailingZeros().toPlainString());

        BigDecimal c = new BigDecimal("600");
        assertEquals("600", c.stripTrailingZeros().toPlainString());

    }

    /**
     *  利用正则表达式去掉小数部分多余的零
     */
    @Test
    public void removeDecimalZeroTest2() {
        BigDecimal a = new BigDecimal("600.00");
        assertEquals("600", removeDecimalZeroByRegex(a.toString()));

        BigDecimal b = new BigDecimal("600.00100");
        assertEquals("600.001", removeDecimalZeroByRegex(b.toString()));

        BigDecimal c = new BigDecimal("600");
        assertEquals("600", removeDecimalZeroByRegex(c.toString()));

    }

    private String removeDecimalZeroByRegex(String str) {
        if (str.toString().indexOf(".") > 0) {
            str = str.replaceAll("0+?$", "");
            str = str.replaceAll("[.]$", "");
        }
        return str;
    }
}
