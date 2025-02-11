package org.example.taskoop5;

public class AgeValidationRule extends ValidationRule<Byte> {
    public AgeValidationRule(Byte value) {
        super(value, "Возраст должен быть 18 или больше");
        }

    @Override
    public boolean isValid() {
        return value >= 18;
    }
}
