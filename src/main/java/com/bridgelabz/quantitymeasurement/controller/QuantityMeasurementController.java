package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.Unit;
import com.bridgelabz.quantitymeasurement.UnitType;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;

    @GetMapping("/unit")
    public List<UnitType> getUnitType(){
        return iQuantityMeasurementService.getUnitType();
    }

    @GetMapping("/unit/subunits")
    public List<Unit> getSubUnits(@RequestParam(value = "unitType") UnitType unitType) {
        return iQuantityMeasurementService.getSubUnits(unitType);
    }
}
