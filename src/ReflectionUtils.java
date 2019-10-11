import com.sun.jdi.Value;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils {
    public static Map<String, Object> getAllFieldValue(Object o) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> superclass = o.getClass().getSuperclass();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(o));
            }
            clazz = clazz.getClass().getClass();
        }
        return map;
    }
}




