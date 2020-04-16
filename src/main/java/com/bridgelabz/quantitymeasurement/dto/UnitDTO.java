package com.bridgelabz.quantitymeasurement.dto;

import com.bridgelabz.quantitymeasurement.UnitType;

public class UnitDTO {
    UnitType unitType;

    public UnitDTO(UnitType unitType) {
        this.unitType = unitType;
    }

    public UnitType getUnitType() {
        return unitType;
    }
}
