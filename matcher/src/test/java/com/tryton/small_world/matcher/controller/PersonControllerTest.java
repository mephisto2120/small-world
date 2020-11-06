package com.tryton.small_world.matcher.controller;

import com.tryton.small_world.matcher.MatcherApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MatcherApplication.class)
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/person/get?customerId=-1"))
            .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnPersonByCustomerId() throws Exception {
        mockMvc.perform(get("/person/get?customerId=987"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.[0].customerId", is(987)))
            .andExpect(jsonPath("$.[0].personId", is(999)))
            .andExpect(jsonPath("$.[0].firstName", is("John")))
            .andExpect(jsonPath("$.[0].lastName", is("Debtor")))
            .andExpect(jsonPath("$.[0].birthDate", is("1970-02-04")))
            .andExpect(jsonPath("$.[0].city", is("New York")))
            .andExpect(jsonPath("$.[0].street", is("Washington")))
            .andExpect(jsonPath("$.[0].houseNumber", is("24")))
            .andExpect(jsonPath("$.[0].email", is("john.debtor@gmail.com")));
    }

    @Test
    void shouldReturnPersonByLastName() throws Exception {
        mockMvc.perform(get("/person/get?lastName=Debtor"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.[0].customerId", is(987)))
            .andExpect(jsonPath("$.[0].personId", is(999)))
            .andExpect(jsonPath("$.[0].firstName", is("John")))
            .andExpect(jsonPath("$.[0].lastName", is("Debtor")))
            .andExpect(jsonPath("$.[0].birthDate", is("1970-02-04")))
            .andExpect(jsonPath("$.[0].city", is("New York")))
            .andExpect(jsonPath("$.[0].street", is("Washington")))
            .andExpect(jsonPath("$.[0].houseNumber", is("24")))
            .andExpect(jsonPath("$.[0].email", is("john.debtor@gmail.com")));
    }
}
