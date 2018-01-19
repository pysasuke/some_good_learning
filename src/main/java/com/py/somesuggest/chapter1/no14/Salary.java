package com.py.somesuggest.chapter1.no14;

import java.io.Serializable;

/**
 *
 * @author Administrator
 * @date 2017/9/16 0016
 */
public class Salary implements Serializable {
    private static final long serialVersionUID = 44663L;
    /**
     * 基本工资
     */
    private int basePay;
    /**
     * 绩效工资
     */
    private int bonus;

    public Salary(int basePay, int bonus) {
        this.basePay = basePay;
        this.bonus = bonus;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
