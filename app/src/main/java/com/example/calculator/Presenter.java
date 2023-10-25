package com.example.calculator;

public class Presenter implements Contract.Presenter {
    private final Contract.Model model;
    private final Contract.View view;

    public Presenter(Contract.Model model, Contract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onBtnClick(String btn, String inputField) {
        view.setInputField(model.verify(btn, inputField));
    }

    @Override
    public void onClearBtnClick() {
        view.setInputField(model.clear());
    }

    @Override
    public void onDeleteBtnClick(String inputField) {
        view.setInputField(model.delete(inputField));
    }

    @Override
    public void onModuloBtnClick(String inputField) {

    }
}
