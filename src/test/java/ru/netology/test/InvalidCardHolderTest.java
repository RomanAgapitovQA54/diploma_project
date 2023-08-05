package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;
import ru.netology.pages.MainPage;

import static ru.netology.data.DataHelper.*;

public class InvalidCardHolderTest extends TestBase {

    @Nested
    class FieldOwnerOfDebitCardTests {


        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }

        DebitPaymentPage debitPaymentPage = new DebitPaymentPage();

        @Test
        void shouldNotDoPaymentWhenOwnerEmpty() {
            val info = getEmptyOwner();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfShouldFillFieldMessage();
        }


        @Test
        void shouldNotDoPaymentWhenOwnerInCyrillic() {
            val info = getInvalidOwnerWithCyrillic();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenOwnerWithDigits() {
            val info = getInvalidOwnerWithDigits();
            debitPaymentPage.fillForm(info);
            debitPaymentPage.waitIfWrongFormatMessage();
        }


    }

    @Nested
    class FieldOwnerOfCreditCardTests {


        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }

        CreditPaymentPage creditPaymentPage = new CreditPaymentPage();

        @Test
        void shouldNotDoPaymentWhenOwnerEmpty() {
            val info = getEmptyOwner();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfShouldFillFieldMessage();
        }


        @Test
        void shouldNotDoPaymentWhenOwnerInCyrillic() {
            val info = getInvalidOwnerWithCyrillic();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenOwnerWithDigits() {
            val info = getInvalidOwnerWithDigits();
            creditPaymentPage.fillForm(info);
            creditPaymentPage.waitIfWrongFormatMessage();
        }


    }
}
