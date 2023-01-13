package com.pavel.service;


import com.pavel.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "psharilov@mail.ru";
    public static final String TESTDATA_USER_PASSWORD = "asdfghjk";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
