package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static ru.netology.data.DataHelper.*;

public class InvalidCVCCVVTest extends TestBase {



    @Nested
    class FieldCvvOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }
        DebitPaymentPage DebitPaymentPage = new DebitPaymentPage();
        @Test
        void shouldNotDoPaymentWhenCVVIsEmpty() {
            val info = getEmptyCVV();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfShouldFillFieldMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs1Digit() {
            val info = getInvalidCVVWith1Digit();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs2Digits() {
            val info = getInvalidCVVWith2Digits();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIsAllZero() {
            val info = getInvalidCVVWithAllZero();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }
    }

    @Nested
    class FieldCvvOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }
        CreditPaymentPage CreditPaymentPage = new CreditPaymentPage();
        @Test
        void shouldNotDoPaymentWhenCVVIsEmpty() {
            val info = getEmptyCVV();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfShouldFillFieldMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs1Digit() {
            val info = getInvalidCVVWith1Digit();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIs2Digits() {
            val info = getInvalidCVVWith2Digits();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenCVVIsAllZero() {
            val info = getInvalidCVVWithAllZero();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }
    }
}
