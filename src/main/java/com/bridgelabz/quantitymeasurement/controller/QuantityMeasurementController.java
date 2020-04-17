package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.Unit;
import com.bridgelabz.quantitymeasurement.UnitType;
import com.bridgelabz.quantitymeasurement.dto.ResponseDTO;
import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService iQuantityMeasurementService;

    @GetMapping("/unit")
    public ResponseEntity<List<UnitType>> getUnitType() {
        return new ResponseEntity<>(iQuantityMeasurementService.getUnitType(), HttpStatus.OK);
    }

    @GetMapping("/unit/subunits")
    public ResponseEntity<List<Unit>> getSubUnits(@RequestParam(value = "unit") UnitType unitType) {
        return new ResponseEntity<>(iQuantityMeasurementService.getSubUnits(unitType), HttpStatus.OK);
    }

    @PostMapping("/unit/conversion")
    public ResponseEntity<ResponseDTO> getConvertedValue(@RequestBody UnitDTO unitDTO) {
        double convertedValue = iQuantityMeasurementService.getConvertedValue(unitDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Value Converted", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
