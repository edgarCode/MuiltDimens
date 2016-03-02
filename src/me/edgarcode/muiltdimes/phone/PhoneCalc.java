package me.edgarcode.muiltdimes.phone;

import me.edgarcode.muiltdimes.Calc;

public class PhoneCalc {
    public void calc() {
        Calc calc = new Calc("phone");
        calc.createXML("values", 0.75f, "default values");
        calc.createXML("values-ldpi", 0.35f, "values-ldpi");
        calc.createXML("values-mdpi", 0.5f, "values-mdpi");
        calc.createXML("values-hdpi", 0.75f, "values-hdpi");
        calc.createXML("values-xhdpi", 1.0f, "values-xhdpi");

        System.out.println("calcPhone finish!");
    }
}
