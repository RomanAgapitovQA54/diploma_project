package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;
import ru.netology.pages.MainPage;

import static ru.netology.data.DataHelper.*;

public class InvalidCVCCVVTest extends TestBase {



    @Nested
    class FieldCvvOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();

        @Test
        void shouldNotDoPaymentWhenCVVIsEmpty() {
            val info = getEmptyCVV();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfShouldFillFieldMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs1Digit() {
            val info = getInvalidCVVWith1Digit();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs2Digits() {
            val info = getInvalidCVVWith2Digits();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIsAllZero() {
            val info = getInvalidCVVWithAllZero();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }
    }

    @Nested
    class FieldCvvOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenCVVIsEmpty() {
            val info = getEmptyCVV();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfShouldFillFieldMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs1Digit() {
            val info = getInvalidCVVWith1Digit();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs2Digits() {
            val info = getInvalidCVVWith2Digits();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIsAllZero() {
            val info = getInvalidCVVWithAllZero();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }
    }
}
