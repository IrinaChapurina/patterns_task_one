package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Майкоп", "Горно-Алтайск", "Барнаул", "Благовещенск",
                "Архангельск", "Астрахань", "Уфа", "Элиста", "Черкесск", "Петрозаводск", "Сыктывкар", "Ижевск",
                "Саранск", "Якутск", "Владикавказ", "Красноярск", "Псков", "Ростов-на-Дону", "Нижний Новгород",
                "Самара", "Владимир", "Киров", "Чебоксары", "Магас", "Краснодар", "Астрахань", "Волгоград",
                "Севастополь", "Симферополь", "Нальчик", "Махачкала", "Улан-Удэ", "Нижний Новгород",
                "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Пенза", "Пермь", "Воронеж",
                "Мурманск", "Иркутск", "Ханты-Мансийск", "Томск", "Хабаровск", "Ярославль", "Владивосток",
                "Калининград", "Смоленск", "Тула", "Тверь", "Липецк", "Тольятти", "Ульяновск", "Набережные Челны",
                "Сочи"} ;
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
