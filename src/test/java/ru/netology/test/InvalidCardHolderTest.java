package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.netology.pages.CreditPaymentPage;
import ru.netology.pages.DebitPaymentPage;

import static ru.netology.data.DataHelper.*;

public class InvalidCardHolderTest extends TestBase {

    @Nested
    class FieldOwnerOfDebitCardTests {




        @BeforeEach
        void setUpAllDebitCardTests() {
            mainPage.payWithDebitCard();
        }
        DebitPaymentPage DebitPaymentPage = new DebitPaymentPage();
        @Test
        void shouldNotDoPaymentWhenOwnerEmpty() {
            val info = getEmptyOwner();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfShouldFillFieldMessage();
        }


        @Test
        void shouldNotDoPaymentWhenOwnerInCyrillic() {
            val info = getInvalidOwnerWithCyrillic();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenOwnerWithDigits() {
            val info = getInvalidOwnerWithDigits();
            DebitPaymentPage.fillForm(info);
            DebitPaymentPage.waitIfWrongFormatMessage();
        }


    }

    @Nested
    class FieldOwnerOfCreditCardTests {



        @BeforeEach
        void setUpAllCreditCardTests() {
            mainPage.payWithCreditCard();
        }
        CreditPaymentPage CreditPaymentPage = new CreditPaymentPage();
        @Test
        void shouldNotDoPaymentWhenOwnerEmpty() {
            val info = getEmptyOwner();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfShouldFillFieldMessage();
        }


        @Test
        void shouldNotDoPaymentWhenOwnerInCyrillic() {
            val info = getInvalidOwnerWithCyrillic();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }

        @Test
        void shouldNotDoPaymentWhenOwnerWithDigits() {
            val info = getInvalidOwnerWithDigits();
            CreditPaymentPage.fillForm(info);
            CreditPaymentPage.waitIfWrongFormatMessage();
        }


    }
}
