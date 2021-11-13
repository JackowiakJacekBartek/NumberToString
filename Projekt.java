package com.company;

class NumberToString {

    private String wynik = "";
    private String arg;
    NumberToString(String arg) {
        this.arg=arg;
    }

    private static String units[] = {
            "", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"
    };
    private static String teens[] = {
            "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"
    };
    private static String tenth[] = {
            "", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"
    };
    private static String hundreds[] = {
            "", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset", "dziewięćset"
    };
    private static String variety[] = {
            "miliard", "milion", "tysiąc", "", "miliardy", "miliony", "tysiące", "", "miliardów", "milionów", "tysięcy", ""
    };

    private void number(String number) {
        int u = number.charAt(2) - '0';
        int t = number.charAt(1) - '0';
        int h = number.charAt(0) - '0';

        if (h != 0)
            wynik+=hundreds[h] + " ";
        if (t == 1) {
            wynik+=teens[u] + " ";
            u = 0;
        } else if (t != 0)
            wynik+=tenth[t] + " ";
        if (u != 0)
            wynik+=units[u] + " ";
    }

    private static int i = 0;
    private void variety(Integer number) {
        if (number == 1)
            wynik+=variety[i] + " ";
        if (number > 1 && number < 5)
            wynik+=variety[i + 4] + " ";
        if (number >= 5)
            wynik+=variety[i + 8] + " ";
        i++;
    }

    String numberToString() {
        if (Integer.parseInt(this.arg) == 0) {
            wynik="zero";
            return wynik;
        }
        String mynumber = String.format("%12s", arg).replaceAll(" ", "0");
        String[] tokens = mynumber.split("(?<=\\G.{3})");
        for (String token : tokens) {
            number(token);
            variety(Integer.parseInt(token));
        }
        return wynik;
    }
}

public class Projekt {
    public static void main(String[] args) {
        NumberToString number = new NumberToString(args[0]);
        System.out.printf(number.numberToString());
    }
}