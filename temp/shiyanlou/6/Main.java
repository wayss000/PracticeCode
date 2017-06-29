import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 补全 Main 类的 ioc(String className, Shiyanlou s, String methodName, String name) 方法，实现功能：
1. 反射生成 className 类实例;
2. 找到 className 实例中类型为 Shiyanlou 的变量并调用 set 方法注入参数 s;
3. 然后调用 className 的 methodName 方法传入 name 参数。
 * @author SSS
 *
 */

public class Main {
    // TODO
    public static void ioc(String className, Shiyanlou s, String methodName, String name) {
        Class clz = null;
        Object obj = null;
        try {
            //第一功能
            clz = Class.forName(className);
            obj = clz.newInstance();
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                //第二个功能
                if (field.getType().getName().equals("Shiyanlou")) {
                    String fieldName = field.getName();
                    Method setClz = clz.getMethod(
                            "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), Shiyanlou.class);
                    setClz.invoke(obj, s);
                    //第三个功能
                    Method method = clz.getMethod(methodName, String.class);
                    method.invoke(obj, name);
                    /*第一次实现逻辑，错误，因为没有遵守第三条
                    //通过get方法拿到Shiyanlou实例对象
                    Object shiyanlou = getClz.invoke(obj);
                    //从Shiyanlou对象里面获取methodName方法
                    Method toUp = shiyanlou.getClass().getMethod(methodName, String.class);
                    //反射执行Shiyanlou对象中的方法
                    Object result = toUp.invoke(shiyanlou, name);
                    */
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
