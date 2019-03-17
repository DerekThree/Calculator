package calculator.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import calculator.com.calclibrary.Calculator;

public class MainActivity extends AppCompatActivity {

    Calculator calc = new Calculator();
    TextView display;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    Button add, sub, mul, div, equals, sin, cos, tan;
    double val1, val2;
    String displayed = new String();

    String[] values = new String[2];
    char op = 'N';

    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        display.setText("0.0");
        num1 =  (Button) findViewById(R.id.num1);
        num2 =  (Button) findViewById(R.id.num2);
        num3 =  (Button) findViewById(R.id.num3);
        num4 =  (Button) findViewById(R.id.num4);
        num5 =  (Button) findViewById(R.id.num5);
        num6 =  (Button) findViewById(R.id.num6);
        num7 =  (Button) findViewById(R.id.num7);
        num8 =  (Button) findViewById(R.id.num8);
        num9 =  (Button) findViewById(R.id.num9);
        num0 =  (Button) findViewById(R.id.num0);
        add =  (Button) findViewById(R.id.add);
        sub =  (Button) findViewById(R.id.sub);
        mul =  (Button) findViewById(R.id.mul);
        div =  (Button) findViewById(R.id.div);
        sin =  (Button) findViewById(R.id.sin);
        cos =  (Button) findViewById(R.id.cos);
        tan =  (Button) findViewById(R.id.tan);
        equals =  (Button) findViewById(R.id.equals);


        num1.setOnClickListener(v -> store('1'));
        num2.setOnClickListener(v -> store('2'));
        num3.setOnClickListener(v -> store('3'));
        num4.setOnClickListener(v -> store('4'));
        num5.setOnClickListener(v -> store('5'));
        num6.setOnClickListener(v -> store('6'));
        num7.setOnClickListener(v -> store('7'));
        num8.setOnClickListener(v -> store('8'));
        num9.setOnClickListener(v -> store('9'));
        num0.setOnClickListener(v -> store('0'));
        add.setOnClickListener(v -> store('+'));
        sub.setOnClickListener(v -> store('-'));
        mul.setOnClickListener(v -> store('*'));
        div.setOnClickListener(v -> store('/'));
        sin.setOnClickListener(v -> store('s'));
        cos.setOnClickListener(v -> store('c'));
        tan.setOnClickListener(v -> store('t'));
        equals.setOnClickListener(v -> store('='));

        values[0] = new String();
        values[1] = new String();

    }

    void store (char c){

        int index = (op == 'N') ? 0 : 1;

        switch (c)
        {
            case '+':
            case '-':
            case '*':
            case '/':
                if ((values[0].length() == 0) || (op != 'N')) break;
                op = c;
                displayed += c;
                display.setText(displayed);
                break;
            case 's':
            case 'c':
            case 't':
                if ((values[0].length() == 0) || (op != 'N')) break;
                op = c;
                result = calc.process(values[0], values[1], op);
                values [0] = new String();
                op = 'N';
                display.setText(Double.toString(result));
                displayed = new String();
            case '=':
                if (values[1].length() == 0) break;
                result = calc.process(values[0], values[1], op);
                values [0] = new String();
                values [1] = new String();
                display.setText(Double.toString(result));
                displayed = new String();
                op = 'N';
                break;
            default:
                values[index] += c;
                displayed += c;
                display.setText(displayed);
        }

    }

}
