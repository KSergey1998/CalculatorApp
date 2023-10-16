package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private TextView inputField;
    private TextView outputField;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = findViewById(R.id.input);
        outputField = findViewById(R.id.output);
        TextView btnClear = findViewById(R.id.clear);
        TextView btnDelete = findViewById(R.id.delete);
        TextView btnModulo = findViewById(R.id.modulo);
        TextView btnDivision = findViewById(R.id.division);
        TextView btnSeven = findViewById(R.id.seven);
        TextView btnEight = findViewById(R.id.eight);
        TextView btnNine = findViewById(R.id.nine);
        TextView btnMultiplication = findViewById(R.id.multiplication);
        TextView btnFour = findViewById(R.id.four);
        TextView btnFive = findViewById(R.id.five);
        TextView btnSix = findViewById(R.id.six);
        TextView btnSubtraction = findViewById(R.id.subtraction);
        TextView btnOne = findViewById(R.id.one);
        TextView btnTwo = findViewById(R.id.two);
        TextView btnThree = findViewById(R.id.three);
        TextView btnAddition = findViewById(R.id.addition);
        TextView btnDot = findViewById(R.id.dot);
        TextView btnZero = findViewById(R.id.zero);
        TextView btnEquals = findViewById(R.id.equals);
        presenter = new Presenter(new Calculator(), this);
        onBtnClick(btnClear, btnDelete, btnModulo, btnDivision, btnSeven, btnEight, btnNine,
                btnMultiplication, btnFour, btnFive, btnSix, btnSubtraction, btnOne, btnTwo,
                btnThree, btnAddition, btnDot, btnZero, btnEquals);
    }

    private void onBtnClick(TextView... textViews) {
        for (TextView btn : textViews) {
            btn.setOnClickListener(view -> {
                String inputFieldContent = (String) inputField.getText();
                String btnName = (String) btn.getText();
                switch (btnName) {
                    case "AC":
                        inputField.setText(presenter.clear());
                        break;
                    case "X":
                        inputField.setText(presenter.delete(inputFieldContent));
                        break;
                    case "=":
                        inputField.setText(presenter.count(inputFieldContent));
                        break;
                    default:
                        inputFieldContent += btnName;
                        inputField.setText(inputFieldContent);
                        outputField.setText(presenter.delete(inputFieldContent));
                }
            });
        }
    }
}