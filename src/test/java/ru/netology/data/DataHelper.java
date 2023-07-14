package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataHelper {
    private static final Faker faker = new Faker(Locale.ENGLISH);

    private DataHelper() {

    }

    public static String generateValidHolder() {
        return faker.name().fullName().toUpperCase();
    }
    public static String generateMonth() {

        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateYear() {


        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));

    }
    public static String generateValidCVV() {
        return faker.numerify("###");
    }



    @Value
    public static class CardValidInformationModel {
        String number;
        String month;
        String year;
        String owner;
        String cvv;


    }

    public static CardValidInformationModel getValidApprovedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4441",generateMonth(), generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getValidDeclinedCardData() {
        return new CardValidInformationModel("4444 4444 4444 4442", generateMonth(), generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getEmptyCardNumber() {
        return new CardValidInformationModel("", generateMonth(), generateYear(), generateValidHolder(), generateValidCVV());
    }

//    FIELD NUMBER

    public static CardValidInformationModel getInvalidCardNumberWith15Symbols() {
        return new CardValidInformationModel("4444 4444 4444 444", generateMonth(), generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getInvalidCardNumberAllZero() {
        return new CardValidInformationModel("0000 0000 0000 0000", generateMonth(), generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getEmptyMonth() {
        return new CardValidInformationModel("4444 4444 4444 4441", "", generateYear(), generateValidHolder(), generateValidCVV());
    }


//    FIELD MONTH

    public static CardValidInformationModel getInvalidFormatMonthIsZeroZero() {
        return new CardValidInformationModel("4444 4444 4444 4441", "00", generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getInvalidFormatMonthIsIrrelevant() {
        return new CardValidInformationModel("4444 4444 4444 4441", "13", generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getInvalidFormatMonthIsOneDigit() {
        return new CardValidInformationModel("4444 4444 4444 4441", "8", generateYear(), generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getEmptyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), "", generateValidHolder(), generateValidCVV());
    }

//    FIELD YEAR

    public static CardValidInformationModel getEarlyYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), "20", generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getFutureYear() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), "50", generateValidHolder(), generateValidCVV());
    }

    public static CardValidInformationModel getEmptyOwner() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), "", generateValidCVV());
    }

//    FIELD OWNER

    public static CardValidInformationModel getInvalidOwnerWithCyrillic() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), "Иванов Иван", generateValidCVV());
    }

    public static CardValidInformationModel getInvalidOwnerWithDigits() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), "12345", generateValidCVV());
    }

    public static CardValidInformationModel getEmptyCVV() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), generateValidHolder(), "");
    }


//    FIELD CVV

    public static CardValidInformationModel getInvalidCVVWith1Digit() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), generateValidHolder(), "1");
    }

    public static CardValidInformationModel getInvalidCVVWith2Digits() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), generateValidHolder(), "11");
    }

    public static CardValidInformationModel getInvalidCVVWithAllZero() {
        return new CardValidInformationModel("4444 4444 4444 4441", generateMonth(), generateYear(), generateValidHolder(), "000");
    }


}

