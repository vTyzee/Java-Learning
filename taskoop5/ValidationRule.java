package org.example.taskoop5;

// Дополните базовый класс для всех правил валидации
public abstract class ValidationRule<T> {

    protected final T value;
    private String errorMessage;

    protected ValidationRule(T value, String errorMessage) {
        this.value = value;
        this.errorMessage = errorMessage;
    }


    public abstract boolean isValid();

    public String getErrorMessage(){
        return errorMessage;
    }
}