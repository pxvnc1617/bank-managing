package com.example.bank_coding.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.security.config.http.MatcherType.mvc;

@AutoConfigureMockMvc // Mock(가짜) 환경에 MockMvc 등록
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class SecurityConfigTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void authentication_test() throws Exception {
        // given

        // when
        // ResultActions resultActions = mvc.perform(get("/api/s/hello"));
        // then
    }

    @Test
    public void authorization_test() throws Exception {

    }

}
