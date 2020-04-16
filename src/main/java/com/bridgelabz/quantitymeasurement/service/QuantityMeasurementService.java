package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.Unit;
import com.bridgelabz.quantitymeasurement.UnitType;
import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    public List<UnitType> getUnitType() {
        return Arrays.asList(UnitType.values());
    }

    @Override
    public List<Unit> getSubUnits(UnitType unitType) {
        return Arrays.stream(Unit.values()).filter(unit -> unit.unitType.equals(unitType)).collect(Collectors.toList());
    }
}
