package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;
import ru.netology.pages.MainPage;

import static ru.netology.data.DataHelper.*;

public class InvalidMonthTest extends TestBase {


    @Nested
    class FieldMonthOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();

        @Test
        void shouldNotDoPaymentWhenEmptyMonth() {
            val info = getEmptyMonth();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIsZeroZero() {
            val info = getInvalidFormatMonthIsZeroZero();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenIrrelevantMonth() {
            val info = getInvalidFormatMonthIsIrrelevant();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIs1Digit() {
            val info = getInvalidFormatMonthIsOneDigit();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }
    }

    @Nested
    class FieldMonthOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenEmptyMonth() {
            val info = getEmptyMonth();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIsZeroZero() {
            val info = getInvalidFormatMonthIsZeroZero();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenIrrelevantMonth() {
            val info = getInvalidFormatMonthIsIrrelevant();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongTermMessage();
        }

        @Test
        void shouldNotDoPaymentWhenMonthIs1Digit() {
            val info = getInvalidFormatMonthIsOneDigit();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }
    }
}
