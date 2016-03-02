package me.edgarcode.muiltdimes;

import java.util.Scanner;

import org.dom4j.Element;

import me.edgarcode.muiltdimes.phone.PhoneCalc;
import me.edgarcode.muiltdimes.tv.TVCalc;

/**
 * 基准分辨率是1280x720--160
 * 
 * @author zhangjifeng
 *
 */
public class Main {
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_TV = 2;
    public static void main(String[] args) {
        System.out.println("1、android手机");
        System.out.println("2、android电视或盒子");
        System.out.print("请选择平台编号：");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();
        in.close();

        switch (type) {
        case TYPE_PHONE:
            calcPhone();
            break;
        case TYPE_TV:
            calcTV();
            break;
        }
        System.exit(0);
    }

    private static void calcPhone() {
        System.out.println("calcPhone");
        new PhoneCalc().calc();
    }

    private static void calcTV() {
        System.out.println("before calcTV");
        new TVCalc().calc();
    }
}
