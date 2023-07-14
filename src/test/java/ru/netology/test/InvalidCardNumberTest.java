package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static ru.netology.data.DataHelper.*;


public class InvalidCardNumberTest extends TestBase {



    @Nested
    class FieldNumberOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }
        DebitPaymentPage DebitPaymentPage = new DebitPaymentPage();
        @Test
        void shouldNotDoPaymentWhenEmptyCard() {
            val info = getEmptyCardNumber();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhen15Symbols() {
            val info = getInvalidCardNumberWith15Symbols();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenAllZero() {
            val info = getInvalidCardNumberAllZero();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfFailMessage();
        }


    }

    @Nested
    class FieldNumberOfCreditCardTests {




        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }
        CreditPaymentPage CreditPaymentPage = new CreditPaymentPage();
        @Test
        void shouldNotDoPaymentWhenEmptyCard() {
            val info = getEmptyCardNumber();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhen15Symbols() {
            val info = getInvalidCardNumberWith15Symbols();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenAllZero() {
            val info = getInvalidCardNumberAllZero();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfFailMessage();
        }


    }
}


