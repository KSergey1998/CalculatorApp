package com.example.calculator;

public class Presenter implements Contract.Presenter {
    private final Contract.Model model;
    private final Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public String clear() {
        return "";
    }

    @Override
    public String delete(String inputFieldContent) {
        if (inputFieldContent.isEmpty()) {
            return inputFieldContent;
        } else {
            return inputFieldContent.substring(0, inputFieldContent.length() - 1);
        }
    }

    @Override
    public String count(String inputFieldContent) {
        return model.count(inputFieldContent);
    }

    @Override
    public String verify(String inputFieldContent, String btnName) {
        if (inputFieldContent.isEmpty()) {
            if (Character.isDigit(btnName.charAt(0))) {
                return btnName;
            } else {
                if (btnName.equals("-")) {
                    return btnName;
                }
                if (btnName.equals("0")) {
                    return "";
                }
                if (btnName.equals(".")) {
                    return "0.";
                } else {
                    return "";
                }
            }
        } else {
            if (Character.isDigit(btnName.charAt(0))) {
                return inputFieldContent.concat(btnName);
            } else {
                char lastSymbol = inputFieldContent.charAt(inputFieldContent.length() - 1);
                if (Character.isDigit(lastSymbol)) {
                    return inputFieldContent.concat(btnName);
                } else {
                    return "";
                }
            }
        }
    }
}
