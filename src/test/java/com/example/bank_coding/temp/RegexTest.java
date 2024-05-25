package com.example.bank_coding.temp;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

// java.util.regex.
public class RegexTest {
    @Test
    public void onlyKoreanTest() throws Exception {
        String value = "한글테스트";
        boolean result = Pattern.matches("^[ㄱ-ㅎ가-힣]+$", value);
        System.out.println("테스트: " + result);
    }

    @Test
    public void notKoreanTest() throws Exception {
        String value = "abc";
        boolean result = Pattern.matches("^[^ㄱ-ㅎ가-힣]*$", value);
        System.out.println("테스트: " + result);
    }

    @Test
    public void onlyEnglishTest() throws Exception {
        String value = "azA";
        boolean result = Pattern.matches("^[a-zA-z]+$", value);
        System.out.println("테스트: " + result);
    }

    @Test
    public void notEnglishTest() throws Exception {
        String value = "가" ;
        boolean result = Pattern.matches("^[^a-zA-Z]*$",value);
        System.out.println("테스트: " + result);
    }

    @Test
    public void englishDigitTest() throws Exception {
        String value = "d1";
        boolean result = Pattern.matches("^[a-zA-Z0-9]+$", value);
        System.out.println("테스트: " + result);
    }

    // 영어만 사용하고 길이는 두글자 이상 네글자 이하.
    @Test
    public void testCondition() throws Exception {
        String value = "aaa";
        boolean result = Pattern.matches("^[a-zA-Z]{2,4}", value);
        System.out.println("테스트: " + result);
    }

    // username, email, fullname
    @Test
    public void user_usernameTest() throws Exception {
        String username = "";
        boolean result = Pattern.matches("^[a-zA-Z0-9]{2,20}", username);
        System.out.println("테스트: " + result);
    }

    @Test
    public void user_fullNameTest() throws Exception {
        String fullName = "";
        boolean result = Pattern.matches("^[a-zA-Z가-힣]{1,20}$", fullName);
        System.out.println("테스트: " + result);
    }

    @Test
    public void user_emailTest() throws Exception {
        String email = "chsong1617@naver.com";
        boolean result = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email);
    }
}
