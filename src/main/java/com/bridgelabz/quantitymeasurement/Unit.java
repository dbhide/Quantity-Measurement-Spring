package com.bridgelabz.quantitymeasurement;

public enum Unit {
    INCH(1,UnitType.LENGTH), FEET(12,UnitType.LENGTH);

    public final double baseUnit;
    public final UnitType unitType;

    Unit(double baseUnit, UnitType unitType) {
        this.baseUnit = baseUnit;
        this.unitType = unitType;
    }
}
