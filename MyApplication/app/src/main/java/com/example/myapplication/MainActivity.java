package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button[] buttons = new Button[10];
    TextView textResult;
    int[] buttonIds = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    Button buttonDot, button, buttonAddition, buttonSubtraction, buttonMultiplication, buttonDivision, buttonPercent, buttonDelete, buttonClear;
    String string;
    String string1;
    String string2;
    String string3;
    double result;
    boolean string3Open = false;
    boolean clear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MyClick myClick = new MyClick();
        for (Button button : buttons) {
            button.setOnClickListener(myClick);
        }
        buttonDot.setOnClickListener(myClick);
        button.setOnClickListener(myClick);
        buttonAddition.setOnClickListener(myClick);
        buttonSubtraction.setOnClickListener(myClick);
        buttonMultiplication.setOnClickListener(myClick);
        buttonDivision.setOnClickListener(myClick);
        buttonPercent.setOnClickListener(myClick);
        buttonDelete.setOnClickListener(myClick);
        buttonClear.setOnClickListener(myClick);
    }

    private void initView() {
        textResult = findViewById(R.id.textResult);
        string = (String) textResult.getText();
        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);
        }
        buttonDot = findViewById(R.id.buttonDot);
        button = findViewById(R.id.button);
        buttonAddition = findViewById(R.id.buttonAddition);
        buttonSubtraction = findViewById(R.id.buttonSubtraction);
        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonClear = findViewById(R.id.buttonClear);
    }

    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button0:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "0";
                        clear = false;
                    } else {
                        string += "0";
                    }
                    break;
                case R.id.button1:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "1";
                        clear = false;
                    } else {
                        string += "1";
                    }
                    break;
                case R.id.button2:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "2";
                        clear = false;
                    } else {
                        string += "2";
                    }
                    break;
                case R.id.button3:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "3";
                        clear = false;
                    } else {
                        string += "3";
                    }
                    break;
                case R.id.button4:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "4";
                        clear = false;
                    } else {
                        string += "4";
                    }
                    break;
                case R.id.button5:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "5";
                        clear = false;
                    } else {
                        string += "5";
                    }
                    break;
                case R.id.button6:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "6";
                        clear = false;
                    } else {
                        string += "6";
                    }
                    break;
                case R.id.button7:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "7";
                        clear = false;
                    } else {
                        string += "7";
                    }
                    break;
                case R.id.button8:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "8";
                        clear = false;
                    } else {
                        string += "8";
                    }
                    break;
                case R.id.button9:
                    if (textResult.getText().equals("0")) {
                        string = "";
                        textResult.setText(string);
                    }
                    if (clear) {
                        string = "9";
                        clear = false;
                    } else {
                        string += "9";
                    }
                    break;
                case R.id.buttonDot:
                    if (clear) {
                        string = "0.";
                        clear = false;
                    } else {
                        if (string3Open) {
                            if (string.substring(string1.length() + 1).length() == 0) {
                                break;
                            }
                            if (string.substring(string1.length() + 1).indexOf(".") == -1) {
                                string += ".";
                            }
                        } else {
                            if (string.indexOf(".") == -1) {
                                string += ".";
                            }
                        }
                    }
                    break;
                case R.id.button:
                    if (string3Open) {
                        string3 = string.substring(string1.length() + 1);
                        if (string3.length() == 0) {
                            break;
                        }
                        result = calculate(Double.parseDouble(string1), Double.parseDouble(string3), string2);
                        string = String.valueOf(result);
                        string1 = string;
                        string3Open = false;
                        clear = true;
                    }
                    break;
                case R.id.buttonAddition:
                    if (string3Open) {
                        string3 = string.substring(string1.length() + 1);
                        if (string3.length() == 0) {
                            break;
                        }
                        result = calculate(Double.parseDouble(string1), Double.parseDouble(string3), string2);
                        string = String.valueOf(result);
                        string1 = string;
                    } else {
                        string1 = string;
                        string3Open = true;
                        clear = false;
                    }
                    string += "+";
                    string2 = "+";
                    break;
                case R.id.buttonSubtraction:
                    if (string3Open) {
                        string3 = string.substring(string1.length() + 1);
                        if (string3.length() == 0) {
                            break;
                        }
                        result = calculate(Double.parseDouble(string1), Double.parseDouble(string3), string2);
                        string = String.valueOf(result);
                        string1 = string;
                    } else {
                        string1 = string;
                        string3Open = true;
                        clear = false;
                    }
                    string += "-";
                    string2 = "-";
                    break;
                case R.id.buttonMultiplication:
                    if (string3Open) {
                        string3 = string.substring(string1.length() + 1);
                        if (string3.length() == 0) {
                            break;
                        }
                        result = calculate(Double.parseDouble(string1), Double.parseDouble(string3), string2);
                        string = String.valueOf(result);
                        string1 = string;
                    } else {
                        string1 = string;
                        string3Open = true;
                        clear = false;
                    }
                    string += "×";
                    string2 = "*";
                    break;
                case R.id.buttonDivision:
                    if (string3Open) {
                        string3 = string.substring(string1.length() + 1);
                        if (string3.length() == 0) {
                            break;
                        }
                        result = calculate(Double.parseDouble(string1), Double.parseDouble(string3), string2);
                        string = String.valueOf(result);
                        string1 = string;
                    } else {
                        string1 = string;
                        string3Open = true;
                        clear = false;
                    }
                    string += "÷";
                    string2 = "/";
                    break;
                case R.id.buttonPercent:
                    if (result == 0) {
                        break;
                    }
                    result = result * 0.01;
                    string = String.valueOf(result);
                    break;
                case R.id.buttonDelete:
                    if (string.equals("Infinity") || string.equals("NaN")) {
                        string = "0";
                    }
                    if (string.equals("")) {
                        string = "0";
                        string3Open = false;
                        break;
                    }
                    string = string.substring(0, string.length() - 1);
                    if (string3Open && string.length() < string1.length() + string2.length()) {
                        string2 = "";
                        string3Open = false;
                    }
                    if (string.equals("")) {
                        string = "0";
                        string3Open = false;
                    }
                    break;
                case R.id.buttonClear:
                    string = "0";
                    result = 0;
                    string3Open = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
            textResult.setText(string);
        }

        public double calculate(double d1, double d2, String str) {
            switch (str) {
                case "+":
                    return d1 + d2;
                case "-":
                    return d1 - d2;
                case "*":
                    return d1 * d2;
                case "/":
                    return d1 / d2;
            }
            return Double.parseDouble(null);
        }
    }
}