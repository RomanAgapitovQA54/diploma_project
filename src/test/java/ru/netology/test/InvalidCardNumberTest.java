package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;
import ru.netology.pages.MainPage;

import static ru.netology.data.DataHelper.*;


public class InvalidCardNumberTest extends TestBase {



    @Nested
    class FieldNumberOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();

        @Test
        void shouldNotDoPaymentWhenEmptyCard() {
            val info = getEmptyCardNumber();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhen15Symbols() {
            val info = getInvalidCardNumberWith15Symbols();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenAllZero() {
            val info = getInvalidCardNumberAllZero();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfFailMessage();
        }


    }

    @Nested
    class FieldNumberOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenEmptyCard() {
            val info = getEmptyCardNumber();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhen15Symbols() {
            val info = getInvalidCardNumberWith15Symbols();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenAllZero() {
            val info = getInvalidCardNumberAllZero();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfFailMessage();
        }


    }
}


