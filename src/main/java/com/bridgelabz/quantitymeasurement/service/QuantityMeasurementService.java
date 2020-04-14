package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.UnitType;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {
    public List<UnitType> getUnitType() {
        List<UnitType> unitType = new ArrayList<>();
        unitType.add(UnitType.LENGTH);
        return unitType;
    }
}
