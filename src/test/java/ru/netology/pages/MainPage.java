package ru.netology.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
public class MainPage {
    private final SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private final SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));

    public MainPage() {
        SelenideElement heading = $$("h2").find(text("Путешествие дня"));
        heading.shouldBe(visible);
    }

    public DebitPaymentPage payWithDebitCard() {
        buyButton.click();
        return new DebitPaymentPage();
    }

    public CreditPaymentPage payWithCreditCard() {
        creditButton.click();
        return new CreditPaymentPage();
    }
}