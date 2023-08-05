package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;
import ru.netology.pages.MainPage;

import static ru.netology.data.DataHelper.*;

public class InvalidYearTest extends TestBase {



    @Nested
    class FieldYearOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();


        @Test
        void shouldNotDoPaymentWhenYearEmpty() {

            val info = getEmptyYear();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsEarly() {
            val info = getEarlyYear();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfCardExpiredMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsFuture() {
            val info = getFutureYear();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongTermMessage();
        }
    }

    @Nested
    class FieldYearOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenYearEmpty() {
            val info = getEmptyYear();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsEarly() {
            val info = getEarlyYear();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfCardExpiredMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsFuture() {
            val info = getFutureYear();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongTermMessage();
        }
    }
}