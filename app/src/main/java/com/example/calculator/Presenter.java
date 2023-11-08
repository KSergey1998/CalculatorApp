package com.example.calculator;

public class Presenter implements Contract.Presenter {
    private final Contract.Model model;
    private final Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onBtnClick(String btn, String expression) {
        expression = model.verify(btn, expression);
        view.setExpressionField(expression);
        view.setResultField(model.count(expression));
    }

    @Override
    public void onClearBtnClick() {
        view.setExpressionField(model.clear());
        view.setResultField("");
    }

    @Override
    public void onDeleteBtnClick(String expression) {
        expression = model.delete(expression);
        view.setExpressionField(expression);
        view.setResultField(model.count(expression));
    }

    @Override
    public void onModuloBtnClick(String expression) {
        expression = model.modulo(expression);
        view.setExpressionField(expression);
        view.setResultField(model.count(expression));
    }

    @Override
    public void onEqualsBtnClick(String expression) {
        view.setExpressionField(model.count(expression));
    }
}
