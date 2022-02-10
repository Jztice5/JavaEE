package SM;


/**
 * @author Jztice5
 * @date 2022年01月30日 18:21
 */

public class Student {
    private String name;
    private String id;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(String name, String id, String sex, int age) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
