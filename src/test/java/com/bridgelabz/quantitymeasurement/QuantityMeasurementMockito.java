package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementMockito {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService iQuantityMeasurementService;

    @Test
    void quantityMeasurement_ShouldReturnUnitType() throws Exception {
        List<UnitType> expectedList = Arrays.asList(UnitType.values());
        given(iQuantityMeasurementService.getUnitType()).willReturn(expectedList);
        mockMvc.perform(MockMvcRequestBuilders.get("/unit").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(expectedList)));
    }

    @Test
    void quantityMeasurement_ShouldReturnSubUnits() throws Exception {
        List<Unit> subUnitList = Arrays.stream(Unit.values()).filter(subUnit -> subUnit.unitType.equals(UnitType.LENGTH)).collect(Collectors.toList());
        given(iQuantityMeasurementService.getSubUnits(UnitType.LENGTH)).willReturn(subUnitList);
        mockMvc.perform(MockMvcRequestBuilders.get("/unit/subunits?unitType={unitType}", UnitType.LENGTH).accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(subUnitList)));
    }
}
