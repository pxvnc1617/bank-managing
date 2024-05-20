package com.example.bank_coding.util;

import com.example.bank_coding.dto.ResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

public class CustomResponseUtil {
    public static void unAuthentication(HttpServletResponse response, String msg) throws Exception {
        ObjectMapper om = new ObjectMapper();
        ResponseDto<?> responseDto = new ResponseDto<>(-1, msg, null);
        String responseBody = om.writeValueAsString(responseDto);
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(401);
        response.getWriter().println(responseBody);
    }
}
