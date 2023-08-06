package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;
import static ru.netology.data.DataHelper.getValidApprovedCardData;
import static ru.netology.data.DataHelper.getValidDeclinedCardData;
import static ru.netology.data.RestApiHelper.fillPaymentFormWithCreditCardData;
import static ru.netology.data.RestApiHelper.fillPaymentFormWithDebitCardData;
import static ru.netology.data.SQLHelper.*;


class ApiTest {

    @Test
    void shouldGiveResponseForValidApprovedDebitCard() {
        val validApprovedCardForApi = getValidApprovedCardData();
        val response = fillPaymentFormWithDebitCardData(validApprovedCardForApi);
        assertTrue(response.contains("APPROVED"));
        var paymentId = getPaymentId();
        String actualStatus = getStatusForPaymentWithDebitCard(paymentId);
        String expectedStatus = "APPROVED";
        assertEquals(expectedStatus, actualStatus);

    }

    @Test
    void shouldGiveResponseForValidDeclinedDebitCard() {
        val validDeclinedCardForApi = getValidDeclinedCardData();
        val response = fillPaymentFormWithDebitCardData(validDeclinedCardForApi);
        assertTrue(response.contains("DECLINED"));
        var paymentId = getPaymentId();
        String actualStatus = getStatusForPaymentWithDebitCard(paymentId);
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void shouldGiveResponseForValidApprovedCreditCard() {
        val validApprovedCardForApi = getValidApprovedCardData();
        val response = fillPaymentFormWithCreditCardData(validApprovedCardForApi);
        assertTrue(response.contains("APPROVED"));
        var paymentId = getPaymentId();
        String actualStatus = getStatusForPaymentWithCreditCard(paymentId);
        String expectedStatus = "APPROVED";
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void shouldGiveResponseForValidDeclinedCreditCard() {
        val validDeclinedCardForApi = getValidDeclinedCardData();
        val response = fillPaymentFormWithCreditCardData(validDeclinedCardForApi);
        assertTrue(response.contains("DECLINED"));
        var paymentId = getPaymentId();
        String actualStatus = getStatusForPaymentWithCreditCard(paymentId);
        String expectedStatus = "DECLINED";
        assertEquals(expectedStatus, actualStatus);
    }
}