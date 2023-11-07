package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private TextView expressionField;
    private TextView resultField;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expressionField = findViewById(R.id.expression);
        resultField = findViewById(R.id.result);
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

    @Override
    public void setExpressionField(String expressionField) {
        this.expressionField.setText(expressionField);
    }

    @Override
    public void setResultField(String resultField) {
        this.resultField.setText(resultField);
    }

    private void onBtnClick(TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setOnClickListener(view -> {
                String expressionFieldContent = (String) expressionField.getText();
                String btn = (String) textView.getText();

                switch (btn) {
                    case "AC":
                        presenter.onClearBtnClick();
                        break;
                    case "X":
                        presenter.onDeleteBtnClick(expressionFieldContent);
                        break;
                    case "%":
                        presenter.onModuloBtnClick(expressionFieldContent);
                        break;
                    case "=":
                        presenter.onEqualsBtnClick(expressionFieldContent);
                        break;
                    default:
                        presenter.onBtnClick(btn, expressionFieldContent);
                }
            });
        }
    }
}