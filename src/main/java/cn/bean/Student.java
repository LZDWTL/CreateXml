package cn.bean;

/**
 * @author 10237
 * @date 2021-03-14 15:31
 */
public class Student {
    private String Stuid;
    private String name;

    public Student(){
        System.out.println("反射调用了构造函数创建对象!");
    }

    public String getStuid() {
        return Stuid;
    }

    public void setStuid(String stuid) {
        Stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
