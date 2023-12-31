package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.netology.data.DataHelper.getValidApprovedCardData;
import static ru.netology.data.DataHelper.getValidDeclinedCardData;
import static ru.netology.data.SQLHelper.*;


public class HappyPathTest extends TestBase {


    @Nested
    class HappyPath1OfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();

        @Test
        void shouldDoPaymentWhenValidApprovedCard() {

            val info = getValidApprovedCardData();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfSuccessMessage();
            val expectedStatus = "APPROVED";
            val actualStatus = getStatusForPaymentWithDebitCard(getPaymentId());
            assertEquals(expectedStatus, actualStatus);
            val expectedId = getPaymentId();
            assertNotNull(expectedId);
            val actualId = getOrderPaymentId();
            assertNotNull(actualId);
            assertEquals(expectedId, actualId);
        }

        @Test
        void shouldNotDoPaymentWhenValidDeclinedCard() {

            val info = getValidDeclinedCardData();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfFailMessage();
            val expectedStatus = "DECLINED";
            val actualStatus = getStatusForPaymentWithDebitCard(getPaymentId());
            assertEquals(expectedStatus, actualStatus);
            val expectedId = getPaymentId();
            assertNotNull(expectedId);
            val actualId = getOrderPaymentId();
            assertNotNull(actualId);
            assertEquals(expectedId, actualId);
        }
    }

    @Nested
    class HappyPath2OfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldDoPaymentWhenValidApprovedCreditCard() {

            val info = getValidApprovedCardData();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfSuccessMessage();
            val expectedStatus = "APPROVED";
            val actualStatus = getStatusForPaymentWithCreditCard(getPaymentId());
            assertEquals(expectedStatus, actualStatus);
            val expectedId = getCreditId();
            assertNotNull(expectedId);
            val actualId = getOrderCreditId();
            assertNotNull(actualId);
            assertEquals(expectedId, actualId);
        }

        @Test
        void shouldNotDoPaymentWhenValidDeclinedCreditCard() {

            val info = getValidDeclinedCardData();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfFailMessage();
            val expectedStatus = "DECLINED";
            val actualStatus = getStatusForPaymentWithCreditCard(getPaymentId());
            assertEquals(expectedStatus, actualStatus);
            val expectedId = getCreditId();
            assertNotNull(expectedId);
            val actualId = getOrderCreditId();
            assertNotNull(actualId);
            assertEquals(expectedId, actualId);
        }
    }


}