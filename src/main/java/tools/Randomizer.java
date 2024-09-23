package tools;

import com.github.javafaker.Faker;

public class Randomizer {
    public static int generateInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static String generateUsername() {
        Faker faker = new Faker();
        return faker.name().username();
    }
    public static String generateCompanyName(){
        Faker faker = new Faker();
        return faker.company().name();
    }
    public static String generateTaskName() {
        Faker faker = new Faker();
        return faker.cat().name();
    }

}
