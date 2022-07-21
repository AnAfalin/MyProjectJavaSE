package part3.task6;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Utils {

    public static <T> List<T> readAllLines(String filename, Class<T> clazz) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filename));                       //все строки из файла
        List<String> headers = Arrays.stream(lines.get(0).split(" ")).toList();     //заголовки - 1ая строка
        List<Field> fields = getField(headers, clazz);

        List<T> objects = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            T object = clazz.getDeclaredConstructor().newInstance();
            String[] values = lines.get(i).split(" ");
            for (int j = 0; j < values.length; j++) {
                Field field = fields.get(j);
                field.setAccessible(true);
                String value = values[j];
                setField(object, field, value);
            }
            objects.add(object);
        }
        return objects;
    }

    private static List<Field> getField(List<String> headers, Class<?> clazz){
        return headers
                .stream()
                .map(field -> {
                    try {
                        return clazz.getDeclaredField(field.toLowerCase());
                    } catch (NoSuchFieldException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();
    }

    public static void setField(Object object, Field field, String value) throws IllegalAccessException {
        Class<?> clazz = field.getType();
        if (clazz == int.class || clazz == Integer.class) {
            field.set(object, Integer.parseInt(value));
            return;
        }
        if (clazz == double.class || clazz == Double.class) {
            field.set(object, Double.parseDouble(value));
            return;
        }
        if (clazz == long.class || clazz == Long.class) {
            field.set(object, Long.parseLong(value));
            return;
        }
        if (clazz == float.class || clazz == Float.class) {
            field.set(object, Float.parseFloat(value));
            return;
        }
        if (clazz == String.class) {
            field.set(object, value);
        }
        if (clazz == LocalDate.class){
            field.set(object, LocalDate.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        }
        if (clazz == LocalTime.class){
            field.set(object, LocalTime.parse(value, DateTimeFormatter.ofPattern("HH-mm-ss")));

        }
        if (clazz == LocalDateTime.class){
            field.set(object, LocalDateTime.parse(value, DateTimeFormatter.ofPattern("HH-mm-ss dd.MM.yyyy")));

        }
    }
}
