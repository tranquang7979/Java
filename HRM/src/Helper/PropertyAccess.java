package Helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PropertyAccess {

    /**
     * Retrieve a value from a property using
     * 
     * @param obj The object who's property you want to fetch
     * @param property The property name
     * @param defaultValue A default value to be returned if either a) The property is
     *  not found or b) if the property is found but the value is null
     * @return THe value of the property
     */
//    public static <T> T getProperty(Object obj, String property, T defaultValue) {
//
//        T returnValue = (T) getProperty(obj, property);
//        if (returnValue == null) {
//            returnValue = defaultValue;
//        }
//
//        return returnValue;
//
//    }

    /**
     * Fetch a property from an object. For example of you wanted to get the foo
     * property on a bar object you would normally call {@code bar.getFoo()}. This
     * method lets you call it like {@code BeanUtil.getProperty(bar, "foo")}
     * @param obj The object who's property you want to fetch
     * @param property The property name
     * @return The value of the property or null if it does not exist.
     */
//    public static Object getProperty(Object obj, String property) {
//        Object returnValue = null;
//
//        try {
//            String methodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
//            Class clazz = obj.getClass();
//            Method method = clazz.getMethod(methodName, null);
//            returnValue = method.invoke(obj, null);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return returnValue;
//    }
    

    public static <T,K> K getPropertyGeneric(T obj, Class<T> cls, String property, K defaultValue) {

        K returnValue = (K) getPropertyGeneric(obj,cls, property);
        if (returnValue == null) {
            returnValue = defaultValue;
        }

        return returnValue;

    }
    public static <T> Object getPropertyGeneric(T obj, Class<T> cls, String property) {
        Object returnValue = null;

        try {
            String methodName = "get" + property.substring(0, 1).toUpperCase() + property.substring(1, property.length());            
            Method method = cls.getMethod(methodName, null);
            returnValue = method.invoke(obj, null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return returnValue;
    }


//    public static <T> String[] getProperties(Class<T> cls) {    	
//    	Field[] fields = cls.getFields();
//    	String[] propertyNames = new String[fields.length]; 
//	    for (int i = 0; i < fields.length; i++) {
//	    	Field f = fields[i];
//	        //System.out.println("-> " + f.getName());
//	        propertyNames[i] = f.getName();
//	      }
//	    return propertyNames;
//    }

}