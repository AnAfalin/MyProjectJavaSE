package lesson.test6;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Utils {

    public static <T> List<T> readAllLines(String filename, Class<T> clazz) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(filename));
        List<String> headers = Arrays.stream(lines.get(0).split(" ")).toList();
        List<Field> fields = getField(headers, clazz);

        List<T> objects = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            T object = clazz.getDeclaredConstructor().newInstance();
            String[] values = lines.get(i).split(" ");
            for (int j = 0; j < values.length; j++) {
                Field f = fields.get(j);
                f.setAccessible(true);
                String value = values[j];
                setField(object, f, value);
            }
            objects.add(object);
        }
        return objects;
    }

    private static List<Field> getField(List<String> headers, Class<?> clazz) {
        return headers
                .stream()
                .map(field -> {
                    try {
                        return clazz.getDeclaredField(field);
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
    }
}
