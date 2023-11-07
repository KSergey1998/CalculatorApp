package com.example.calculator;

public interface Contract {
    interface Model {
        String verify(String btn, String expression);

        String clear();

        String delete(String expression);

        String modulo(String expression);

        String count(String expression);
    }

    interface View {
        void setExpressionField(String expressionField);

        void setResultField(String resultField);
    }

    interface Presenter {
        void onBtnClick(String btn, String expression);

        void onClearBtnClick();

        void onDeleteBtnClick(String expression);

        void onModuloBtnClick(String expression);

        void onEqualsBtnClick(String expression);
    }
}
