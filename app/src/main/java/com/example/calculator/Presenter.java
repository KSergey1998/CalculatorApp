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
}
