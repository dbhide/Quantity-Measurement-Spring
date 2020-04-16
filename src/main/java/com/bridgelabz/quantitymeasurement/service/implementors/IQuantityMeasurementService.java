package com.bridgelabz.quantitymeasurement.service.implementors;

import com.bridgelabz.quantitymeasurement.Unit;
import com.bridgelabz.quantitymeasurement.UnitType;

import java.util.List;

public interface IQuantityMeasurementService {
    List<UnitType> getUnitType();

    List<Unit> getSubUnits(UnitType unitType);
}
