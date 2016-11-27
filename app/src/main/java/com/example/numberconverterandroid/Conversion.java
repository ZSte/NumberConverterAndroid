package com.example.numberconverterandroid;

/**
 * Contains functionality for the conversion of numbers
 * Created by ZSte on 26.11.2016.
 * @author ZSte
 */

public class Conversion {
    String result;
    /**
     * Empty constructor
     */
    public Conversion() {
        result = "";
    }
    /**
     * Converts the number from system fromSys to system toSys
     * @param number The number which is converted
     * @param fromSys The System of number
     * @param toSys The System in which number is converted
     */
    public String convert(int number, int fromSys, int toSys) {
        result = "";
        if (fromSys == toSys) {
            result = number + "";
            return result;
        }
        String [] array = new String[24];
        for(int i = 0; i < 24; i++) {
            array[i] = "";
        }
        int n = number;
        if (fromSys == 10) {
            int j = 0;
                while(n > 0) {
                    array[j] = n % toSys + "";
                    j++;
                    n = n/toSys;
                }
                for(int i = array.length - 1; i >= 0; i--) {
                    result = result + array[i];
                }
            }
        else if(toSys == 10) {
            int tmpResult = 0;
            String tmp = number + "";
            int []numberAsArray = new int[tmp.length()];

            for(int i = 0; i < tmp.length(); i++) {
                numberAsArray[tmp.length() - i - 1] = tmp.charAt(i) - '0';
            }
            for (int j = 0; j < tmp.length(); j++) {
                tmpResult = (int) (tmpResult + (Math.pow(fromSys, j) * numberAsArray[j]));
            }
            result = result + tmpResult;
        }
        else {

        }
        return result;
        }
    }
