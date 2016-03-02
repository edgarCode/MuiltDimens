package me.edgarcode.muiltdimes.tv;

import me.edgarcode.muiltdimes.Calc;

public class TVCalc {

    public void calc() {
        Calc calc = new Calc("tv");
        calc.createXML("values", 0.6667f, "valules-hdpi-1920; values-mdpi-1280; values-xhdpi-2560; values-xxhdpi-3840");
        calc.createXML("values-w1280dp", 0.6667f, "valules-hdpi-1920; values-mdpi-1280; values-xhdpi-2560; values-xxhdpi-3840");
        calc.createXML("values-w1442dp", 0.75f, "values-tvdpi-1920");
        calc.createXML("values-w1920dp", 1.0f, "values-mdpi-1920; values-xhdpi-3840");
        calc.createXML("values-w768dp", 0.4f, "values-400dpi-1920");
        calc.createXML("values-w853dp", 0.4444f, "values-hdpi-1280; values-xxhdpi-2560");
        calc.createXML("values-w960dp", 0.5f, "values-xhdpi-1920; values-xxxhdpi-3840; values-tvdpi-1280");

        System.out.println("calcTV finish!");
    }
}
