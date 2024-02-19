package tek.tdd.utility;

import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FakeData {
    public static void main(String[] args) throws ParseException {
        FakeData data = new FakeData();
        System.out.println(data.getFirstName());
        System.out.println(data.getLastName());
        System.out.println(data.getDate());
        System.out.println(data.getJobPosition());
        System.out.println(data.getEmail(data.getFirstName(), data.getLastName()));
    }

    public String getEmail(String firstName, String lastName) {
        int randomNumber = (int) (Math.random() * 10000);
        return firstName + lastName + +randomNumber + "@happy.org";
    }

    public String firstCharacterCapital(String text) {
        return text.substring(0, 1).toUpperCase().concat(text.substring(1).toLowerCase());
    }

    public String generatePassword(String firstName, String lastName) {
        int number = (int) (Math.random() * 100);
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        Random random = new Random();
        String specialCharacter =String.valueOf(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        return firstCharacterCapital(firstName) + specialCharacter + firstCharacterCapital(lastName) + number;
    }

    private Faker getFaker() {
        return new Faker();
    }

    public String getFirstName() {
        return getFaker().name().firstName();
    }

    public String getLastName() {
        return getFaker().name().lastName();
    }

    public String getJobPosition() {
        return getFaker().job().position();
    }

    public String getDate() {
        Date date = getFaker().date().birthday();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(date);
    }

}
