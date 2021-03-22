import cn.bean.Student;
import junit.framework.TestSuite;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 10237
 * @date 2021-03-14 21:09
 */
public class StudentTest extends TestSuite {

    @Test    //说明该方法时一个单元测试方法，可以独立运行
    public void studentTest(){
        try {

            Class clazz=Class.forName("cn.bean.Student");    //构造函数需要权限public才能使用反射创建对象，网上好像也有使用反射调用私有的构造方法创建对象
            Student stu=(Student)clazz.newInstance();
            Field[] field=clazz.getDeclaredFields();
            for(Field field1:field){
                System.out.println(Modifier.toString(field1.getModifiers())+"\t"+field1.getType().getSimpleName()+"\t"+field1.getName());
            }
            Method method =clazz.getMethod("setName", String.class);
            method.invoke(stu,"雪玲珑");
            System.out.println("反射调用方法"+"\t"+stu.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
