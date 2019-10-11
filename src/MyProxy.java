import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
    private final Object delegate;

    public MyProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T>  T time(T delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), delegate.getClass().getInterfaces(), new MyProxy(delegate));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long l = System.currentTimeMillis();
        Object result = method.invoke(delegate, args);
        long g = (long) System.currentTimeMillis() - l;
        System.out.println(g);
        return result;
    }
}
