package com.usk.calculator;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {

    // Helper method untuk klik tombol berdasarkan resource-id
    private void tap(String resourceId) {
        driver.findElement(AppiumBy.id("com.example.calculator:id/" + resourceId)).click();
    }

    // Helper method untuk membaca hasil dari display utama
    private String getResult() {
        WebElement display = driver.findElement(AppiumBy.id("com.example.calculator:id/tvmain"));
        return display.getText();
    }

    @BeforeMethod
    public void clearCalculator() {
        // Bersihkan display sebelum setiap test
        tap("bac");
    }

    // TC01: Penjumlahan (2 + 3 = 5)
    @Test(priority = 1)
    public void testAddition() {
        tap("b2");
        tap("bplus");
        tap("b3");
        tap("bequal");

        String result = getResult();
        Assert.assertEquals(result, "5.0", "Hasil penjumlahan 2 + 3 seharusnya 5.0");
    }

    // TC02: Pengurangan (9 - 4 = 5)
    @Test(priority = 2)
    public void testSubtraction() {
        tap("b9");
        tap("bminus");
        tap("b4");
        tap("bequal");

        String result = getResult();
        Assert.assertEquals(result, "5.0", "Hasil pengurangan 9 - 4 seharusnya 5.0");
    }

    // TC03: Perkalian (6 × 7 = 42)
    @Test(priority = 3)
    public void testMultiplication() {
        tap("b6");
        tap("bmod"); // tombol × resource-id-nya "bmod"
        tap("b7");
        tap("bequal");

        String result = getResult();
        Assert.assertEquals(result, "42.0", "Hasil perkalian 6 x 7 seharusnya 42.0");
    }

    // TC04: Pembagian (8 ÷ 2 = 4)
    @Test(priority = 4)
    public void testDivision() {
        tap("b8");
        tap("bdiv");
        tap("b2");
        tap("bequal");

        String result = getResult();
        Assert.assertEquals(result, "4.0", "Hasil pembagian 8 / 2 seharusnya 4.0");
    }

    // TC05: Tombol Clear (C)
    @Test(priority = 5)
    public void testClearButton() {
        tap("b5");
        tap("bc"); // tombol C (clear)

        String result = getResult();
        Assert.assertTrue(result.isEmpty() || result.equals("0"),
                "Setelah tekan C, display seharusnya kosong/0");
    }
}