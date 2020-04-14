package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;

    @GetMapping("/unit")
    public List getUnitType(){
        return iQuantityMeasurementService.getUnitType();
    }
}
