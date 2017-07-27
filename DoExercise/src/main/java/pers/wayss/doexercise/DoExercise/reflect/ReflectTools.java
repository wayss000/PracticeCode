package pers.wayss.doexercise.DoExercise.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectTools {
    
    /**
     * 功能为通过反射，设置对象的字段，参数map中的key代表字段名称，value代表字段值。
     * 第一个参数所对应的对象的每个字段都应该提供get/set方法
     * @param obj
     * @param map
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public static void reflectSetValue(Object obj, Map map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Class clzz = obj.getClass();
        Set keySet = map.keySet();
        for(Object key : keySet){
            Method m = getSetMethod(clzz, key.toString());
            m.invoke(obj, map.get(key));
        }
    }
    
    public static Method getSetMethod(Class objectClass, String fieldName) {  
        try {  
            Class[] parameterTypes = new Class[1];  
            Field field = objectClass.getDeclaredField(fieldName);  
            parameterTypes[0] = field.getType();  
            StringBuffer sb = new StringBuffer();  
            sb.append("set");  
            sb.append(fieldName.substring(0, 1).toUpperCase());  
            sb.append(fieldName.substring(1));  
            Method method = objectClass.getMethod(sb.toString(), parameterTypes);  
            return method;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    //test method
    public static void main(String [] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Student s = new Student();
        Map map = new HashMap();
        map.put("name", "wayss");
        map.put("age", 24);
        map.put("id", 10);
        reflectSetValue(s, map);
        System.out.println(s);
    }
}

class Student{
    String name;
    int age;
    int id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
