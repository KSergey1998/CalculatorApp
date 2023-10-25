package com.example.calculator;

public class Calculator implements Contract.Model {
    @Override
    public String verify(String btn, String inputField) {
        if (inputField.isEmpty()) {
            switch (btn) {
                case "-":
                    return "0-";
                case ".":
                    return "0.";
                case "+":
                case "*":
                case "/":
                    return "";
                default:
                    return btn;
            }
        } else {
            char lastChar = inputField.charAt(inputField.length() - 1);
            char btnChar = btn.charAt(0);

            if (!Character.isDigit(lastChar) && !Character.isDigit(btnChar)) {
                switch (lastChar) {
                    case '.':
                        if (btn.equals(".")) {
                            return inputField;
                        } else {
                            return inputField.concat("0").concat(btn);
                        }
                    case '-':
                    case '+':
                    case '*':
                    case '/':
                        if (btn.equals(".")) {
                            return inputField.concat("0.");
                        } else {
                            inputField = inputField.substring(0, inputField.length() - 1);
                            return inputField.concat(btn);
                        }
                }
            }

            return inputField.concat(btn);
        }
    }

    @Override
    public String clear() {
        return "";
    }

    @Override
    public String delete(String inputField) {
        if (inputField.isEmpty()) {
            return inputField;
        } else {
            return inputField.substring(0, inputField.length() - 1);
        }
    }

    @Override
    public String modulo(String inputField) {
        return null;
    }

    @Override
    public String count(String inputField) {
        return "";
    }
}
