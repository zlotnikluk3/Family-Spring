package com.FamilyMemberApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.FamilyMemberApp.Contorller.FamilyMemberAppController;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@ExtendWith(MockitoExtension.class)
public abstract class BaseTestClass {

    @InjectMocks
    FamilyMemberAppController fmac;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(this.fmac);

    }

}