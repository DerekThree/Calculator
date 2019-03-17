package calculator.com.calclibrary;

/**
 * Created by Derek on 3/17/2019.
 */

public class Calculator {

    public double process(String string1, String string2, char op){

        if (string1.length() == 0) return 0;

        switch(op){
            case '+':
                return Integer.parseInt(string1) + Integer.parseInt(string2);
            case '-':
                return Integer.parseInt(string1) - Integer.parseInt(string2);
            case '*':
                return Integer.parseInt(string1) * Integer.parseInt(string2);
            case '/':
                return (double) Integer.parseInt(string1) / Integer.parseInt(string2);
            case 's':
                return Math.sin(Integer.parseInt(string1));
            case 'c':
                return Math.cos(Integer.parseInt(string1));
            case 't':
                return Math.tan(Integer.parseInt(string1));
        }

        return 0;

    }

    double add(double val1, double val2){
        return val1+val2;
    }

    double sub(double val1, double val2){
        return val1-val2;
    }

    double mul(double val1, double val2){
        return val1*val2;
    }

    double div(double val1, double val2){
        return val1/val2;
    }

    double sin(double val){
        return Math.sin(val);
    }

    double cos(double val){
        return Math.cos(val);
    }

    double tan(double val){
        return Math.tan(val);
    }

}
