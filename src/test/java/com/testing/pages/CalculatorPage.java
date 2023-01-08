package com.testing.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static java.util.Map.entry;

public class CalculatorPage {
    public CalculatorPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.example.new_sample:id/button0")
    public WebElement button0;

    @FindBy(id = "com.example.new_sample:id/button1")
    public WebElement button1;

    @FindBy(id = "com.example.new_sample:id/button2")
    public WebElement button2;

    @FindBy(id = "com.example.new_sample:id/button3")
    public WebElement button3;

    @FindBy(id = "com.example.new_sample:id/button4")
    public WebElement button4;

    @FindBy(id = "com.example.new_sample:id/button5")
    public WebElement button5;

    @FindBy(id = "com.example.new_sample:id/button6")
    public WebElement button6;

    @FindBy(id = "com.example.new_sample:id/button7")
    public WebElement button7;

    @FindBy(id = "com.example.new_sample:id/button8")
    public WebElement button8;

    @FindBy(id = "com.example.new_sample:id/button9")
    public WebElement button9;

    @FindBy(id = "com.example.new_sample:id/button_dot")
    public WebElement button_dot;

    @FindBy(id = "com.example.new_sample:id/button_clear")
    public WebElement button_clear;

    @FindBy(id = "com.example.new_sample:id/button_para2")
    public WebElement button_negative;

    @FindBy(id = "com.example.new_sample:id/button_para1")
    public WebElement button_modulus;

    @FindBy(id = "com.example.new_sample:id/button_divide")
    public WebElement button_divide;

    @FindBy(id = "com.example.new_sample:id/button_multi")
    public WebElement button_multiply;

    @FindBy(id = "com.example.new_sample:id/button_sub")
    public WebElement button_subtract;

    @FindBy(id = "com.example.new_sample:id/button_add")
    public WebElement button_add;

    @FindBy(id = "com.example.new_sample:id/button_equals")
    public WebElement button_equals;

    @FindBy(id = "com.example.new_sample:id/input")
    public WebElement input;

    @FindBy(id = "com.example.new_sample:id/output")
    public WebElement output;
}
