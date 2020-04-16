package com.bridgelabz.quantitymeasurement;

public enum Unit {
    FEET(12, UnitType.LENGTH), INCH(1, UnitType.LENGTH),
    YARD(36, UnitType.LENGTH), CM(1 / 2.5, UnitType.LENGTH),

    GALLON(3.78, UnitType.VOLUME), LITRE(1, UnitType.VOLUME),
    ML(1d / 1000, UnitType.VOLUME),

    KG(1, UnitType.WEIGHT), GRAM(1d / 1000, UnitType.WEIGHT),
    TONNE(1000, UnitType.WEIGHT),

    CELSIUS(2.12, UnitType.TEMPERATURE), FAHRENHEIT(1, UnitType.TEMPERATURE);

    public final double conversionValue;
    public final UnitType unitType;

    Unit(double conversionValue, UnitType unitType) {
        this.conversionValue = conversionValue;
        this.unitType = unitType;
    }
}
