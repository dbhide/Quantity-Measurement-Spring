package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.service.implementors.IQuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementMockito {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService iQuantityMeasurementService;

    @Test
    public void quantityMeasurementTest() throws Exception {
        List<UnitType> expectedList = new ArrayList<>();
        expectedList.add(UnitType.LENGTH);
        given(iQuantityMeasurementService.getUnitType()).willReturn(expectedList);
        mockMvc.perform(get("/unit")).andDo(print())
        .andExpect(status().isOk()).andExpect(content().json(String.valueOf(expectedList)));
    }
}
