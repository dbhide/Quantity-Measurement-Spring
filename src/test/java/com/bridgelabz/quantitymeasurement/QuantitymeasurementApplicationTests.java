package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class QuantitymeasurementApplicationTests {

	@Autowired
	IQuantityMeasurementService iQuantityMeasurementService;


	@Test
	void contextLoads() {
	}

	@Test
	void testForGettingAllUnitType() {
		List<UnitType> actualList = new ArrayList<>();
		actualList.add(UnitType.LENGTH);
		List<UnitType> expectedList = iQuantityMeasurementService.getUnitType();
		Assertions.assertEquals(actualList,expectedList);
	}
}
