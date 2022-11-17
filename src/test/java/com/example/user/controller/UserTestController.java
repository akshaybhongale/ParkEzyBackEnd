package com.example.user.controller;

import com.example.user.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test Controller for testing user controller
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserTestController {

    /**
     *  mock reference for testing API
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Base url for REST API
     */
    private String mBaseURL = "http://localhost:3333/api/v1/user";

    @Test
    public void getAllUser() throws Exception {
        mockMvc.perform(get(mBaseURL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(4)));
    }

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User();
        user.setPassword("HelloPassword");
        user.setName("TestUser");
        user.setAddress("Abc");
        user.setUserId("T_8600");
        user.setMobileNo("9422005826");
        user.setEmail("testUser@gmail.com");
        mockMvc.perform(post(mBaseURL + "/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(user)))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testUpdateName() throws Exception {
        mockMvc.perform(put(
                        mBaseURL + "/updateName/{name}",
                        "hello")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    public void testDeleteTrainee() throws Exception {

        mockMvc.perform(delete(
                        mBaseURL + "/delete/{userId}",
                        "T_8600")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
