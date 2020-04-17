package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.dto.ResponseDTO;
import com.bridgelabz.quantitymeasurement.dto.UnitDTO;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/unit")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(expectedList)));
    }

    @Test
    void quantityMeasurement_ShouldReturnSubUnits() throws Exception {
        List<Unit> subUnitList = Arrays.stream(Unit.values()).filter(subUnit -> subUnit.unitType.equals(UnitType.LENGTH))
                .collect(Collectors.toList());
        given(iQuantityMeasurementService.getSubUnits(UnitType.LENGTH)).willReturn(subUnitList);
        mockMvc.perform(MockMvcRequestBuilders.get("/unit/subunits?unitType={unitType}", UnitType.LENGTH)
                .accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(subUnitList)));
    }

    @Test
    void quantityMeasurement_ShouldReturnConvertedValue() throws Exception {
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setUnitOne(Unit.YARD);
        unitDTO.setUnitTwo(Unit.FEET);
        unitDTO.setActualValue(1.0);
        Gson gson = new Gson();
        String json = gson.toJson(unitDTO);
        given(iQuantityMeasurementService.getConvertedValue(any())).willReturn(3.0);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/unit/conversion")
                .contentType(MediaType.APPLICATION_JSON).content(json)).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);
        double value = (double) responseDTO.getValue();
        Assert.assertEquals(3.0, value, 0.0);
    }
}
