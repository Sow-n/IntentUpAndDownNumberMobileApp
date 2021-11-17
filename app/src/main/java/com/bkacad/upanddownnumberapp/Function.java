package com.bkacad.upanddownnumberapp;

public class Function {
    public static int cong(int a){
        if(a >=1 && a<100){
            return a = a+ 1;
        }else{
            return a;
        }
    }
    public static int tru(int a){
        if(a >1 && a<=100){
            return a = a - 1;
        }else{
            return a;
        }
    }
    public static String numberToWord(int number) {
        // variable to hold string representation of number
        String words = "";
        String unitsArray[] = {"Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu",
                "Bảy", "Tám", "Chín", "Mười", "Mười một", "Mười hai",
                "Mười ba", "Mười bốn", "Mười lăm", "Mười sáu", "Mười bảy",
                "Mười tám", "Mười chín"};
        String tensArray[] = {"Không", "Mười", "Hai mươi", "Ba mươi", "Bốn mươi", "Năm mươi",
                "Sáu mươi", "Bảy mươi", "Tám mươi", "Chín mươi"};

        if (number == 0) {
            return "zero";
        }
        // add minus before conversion if the number is less than 0
//        if (number < 0) {
//            // convert the number to a string
//            String numberStr = "" + number;
//            // remove minus before the number
//            numberStr = numberStr.substring(1);
//            // add minus before the number and convert the rest of number
//            return "minus " + numberToWord(Integer.parseInt(numberStr));
//        }
        // check if number is divisible by 1 million
//        if ((number / 1000000) > 0) {
//            words += numberToWord(number / 1000000) + " million ";
//            number %= 1000000;
//        }
        // check if number is divisible by 1 thousand
//        if ((number / 1000) > 0) {
//            words += numberToWord(number / 1000) + " thousand ";
//            number %= 1000;
//        }
        // check if number is divisible by 1 hundred
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " trăm ";
            number %= 100;
        }

        if (number > 0) {
            // check if number is within teens
            if (number < 20) {
                // fetch the appropriate value from unit array
                words += unitsArray[number];
            } else {
                // fetch the appropriate value from tens array
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    words += " " + unitsArray[number % 10];
                }
            }
        }
        return words;
    }
}
