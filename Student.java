package P_A;

/**
 * @author Jztice5
 * @date 2022年01月19日 14:33
 */

public class Student {
    //学号
    private String id;
    //姓名
    private String name;
    //年龄
    private String age;
    //地址
    private String address;

    public Student() {
    }

    //创建构造方法，将对象的数据接收到本类的成员变量！！！
    public Student(String id, String name, String age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
