package org.example.taskoop5;

public class MortgageAmountValidationRule extends ValidationRule<Integer> {

    public MortgageAmountValidationRule(Integer value) {
        super(value, "Сумма должна быть от 1.000.000 до 10.000.000");
    }

    @Override
    public boolean isValid() {
        return value >= 1_000_000 && value <= 10_000_000;
    }
}