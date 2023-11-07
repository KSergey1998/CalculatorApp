package com.example.calculator;

import com.example.calculator.utils.StringUtils;

import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class Calculator implements Contract.Model {
    @Override
    public String verify(String btn, String expression) {
        char btnChar = btn.charAt(0);

        if (expression.isEmpty()) {
            if (Character.isDigit(btnChar)) {
                return btn;
            } else {
                return "0" + btn;
            }
        } else {
            char lastChar = expression.charAt(expression.length() - 1);

            if (!Character.isDigit(lastChar) && !Character.isDigit(btnChar)) {
                switch (lastChar) {
                    case '.':
                        if (btn.equals(".")) {
                            return expression;
                        } else {
                            return expression.concat("0").concat(btn);
                        }
                    case '-':
                    case '+':
                    case '*':
                    case '/':
                        if (btn.equals(".")) {
                            return expression.concat("0.");
                        } else {
                            expression = expression.substring(0,
                                    expression.length() - 1);
                            return expression.concat(btn);
                        }
                }
            }

            return expression.concat(btn);
        }
    }

    @Override
    public String clear() {
        return "";
    }

    @Override
    public String delete(String expression) {
        if (expression.isEmpty()) {
            return expression;
        }

        if (expression.length() == 2) {
            if (expression.equals("0.")) {
                return "";
            }
        }

        return expression.substring(0, expression.length() - 1);
    }

    @Override
    public String modulo(String expression) {
        if (expression.isEmpty()) {
            return expression;
        }

        String lastNumber = getLastNumberFromExpression(expression);
        String modulo = count(lastNumber + "/100");
        expression = StringUtils.replaceLast(expression, lastNumber, modulo);
        return expression;
    }

    @Override
    public String count(String expression) {
        if (expression.isEmpty()) {
            return expression;
        }

        char lastChar = expression.charAt(expression.length() - 1);

        if (!Character.isDigit(lastChar)) {
            expression = expression.substring(0, expression.length() - 1);
        }

        try {
            Double result = new ExpressionBuilder(expression).build().evaluate();
            String formattedResult = new DecimalFormat("#.##########").format(result);
            formattedResult = formattedResult.replace(",", ".");
            return formattedResult;
        } catch (ArithmeticException exception) {
            return "Can`t divide by zero";
        }
    }

    private String getLastNumberFromExpression(String expression) {
        String digitsStr = expression.replaceAll("[^0-9.]", " ");
        String[] digitsArr = digitsStr.split(" ");
        return digitsArr[digitsArr.length - 1];
    }
}
