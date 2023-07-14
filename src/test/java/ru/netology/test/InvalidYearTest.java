package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static ru.netology.data.DataHelper.*;

public class InvalidYearTest extends TestBase {





    @Nested
    class FieldYearOfDebitCardTests {



        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }
        DebitPaymentPage DebitPaymentPage = new DebitPaymentPage();


        @Test
        void shouldNotDoPaymentWhenYearEmpty() {

            val info = getEmptyYear();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsEarly() {
            val info = getEarlyYear();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfCardExpiredMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsFuture() {
            val info = getFutureYear();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongTermMessage();
        }
    }

    @Nested
    class FieldYearOfCreditCardTests {



        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }
        CreditPaymentPage CreditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenYearEmpty() {
            val info = getEmptyYear();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsEarly() {
            val info = getEarlyYear();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfCardExpiredMessage();
        }

        @Test
        void shouldNotDoPaymentWhenYearIsFuture() {
            val info = getFutureYear();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongTermMessage();
        }
    }
}