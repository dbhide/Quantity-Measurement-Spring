package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.Unit;
import com.bridgelabz.quantitymeasurement.UnitType;

public class UnitDTO {
    Unit unitOne;
    Unit unitTwo;

    double actualValue;

    public Unit getUnitOne() {
        return unitOne;
    }

    public Unit getUnitTwo() {
        return unitTwo;
    }

    public double getActualValue() {
        return actualValue;
    }

    public void setUnitOne(Unit unitOne) {
        this.unitOne = unitOne;
    }

    public void setUnitTwo(Unit unitTwo) {
        this.unitTwo = unitTwo;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
    }
}
