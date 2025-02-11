package org.example.taskoop5;

// Дополните класс для проверки трудоустроенности пользователя
public class EmploymentValidationRule extends ValidationRule<Boolean> {

    public EmploymentValidationRule(Boolean value) {
        super(value, "Вы должны быть трудоустроенным");
    }

    @Override
    public boolean isValid() {
        return value;
    }
}
