package com.example.calculator;

public interface Contract {
    interface Model {
        String count(String inputFieldContent);
    }

    interface View {

    }

    interface Presenter {
        String clear();

        String delete(String inputFieldContent);

        String count(String inputFieldContent);
    }
}
