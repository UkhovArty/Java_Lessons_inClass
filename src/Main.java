import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map map1 = MyProxy.time(new HashMap());
        Map map2 = MyProxy.time(new TreeMap());
        map1.put(1, 15);
        map1.get(1);
        map2.put(1, 13);
        map2.get(1);
    }
}
