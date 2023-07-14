package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static ru.netology.data.DataHelper.*;

public class InvalidMonthTest extends TestBase {



    @Nested
    class FieldMonthOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }
        DebitPaymentPage DebitPaymentPage = new DebitPaymentPage();
        @Test
        void shouldNotDoPaymentWhenEmptyMonth() {
            val info = getEmptyMonth();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIsZeroZero() {
            val info = getInvalidFormatMonthIsZeroZero();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenIrrelevantMonth() {
            val info = getInvalidFormatMonthIsIrrelevant();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIs1Digit() {
            val info = getInvalidFormatMonthIsOneDigit();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }
    }

    @Nested
    class FieldMonthOfCreditCardTests {



        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }
        CreditPaymentPage CreditPaymentPage = new CreditPaymentPage();
        @Test
        void shouldNotDoPaymentWhenEmptyMonth() {
            val info = getEmptyMonth();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIsZeroZero() {
            val info = getInvalidFormatMonthIsZeroZero();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenIrrelevantMonth() {
            val info = getInvalidFormatMonthIsIrrelevant();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIs1Digit() {
            val info = getInvalidFormatMonthIsOneDigit();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }
    }
}
