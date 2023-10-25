package com.example.calculator;

public interface Contract {
    interface Model {
        String verify(String btn, String inputField);

        String clear();

        String delete(String inputField);

        String modulo(String inputField);

        String count(String inputField);
    }

    interface View {
        void setInputField(String inputField);

        void setOutputField(String outputField);
    }

    interface Presenter {
        void onBtnClick(String btn, String inputField);

        void onClearBtnClick();

        void onDeleteBtnClick(String inputField);

        void onModuloBtnClick(String inputField);
    }
}
