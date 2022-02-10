package SM;

import com.sun.scenario.effect.impl.sw.sse.SSEDisplacementMapPeer;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Jztice5
 * @date 2022年01月28日 22:42
 */

public class Text {

    public SetB sex;

    public static void ShowMenu() {
        System.out.println("--------功能如下--------");
        System.out.println("1,添加学生信息");
        System.out.println("2,查看学生信息");
        System.out.println("3,修改学生信息");
        System.out.println("4,删除学生信息");
        System.out.println("5,退出系统");

    }

    //添加
    // private String name;
    //    private String id;
    //    private String sex;
    //    private int age;
    public static void addStudent(ArrayList<Student> list_A) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println("请输入学号：");
        String id = scanner.next();
        System.out.println("请输入性别：");
        String sex = scanner.next();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        Student student1 = new Student(name, id, sex, age);
        list_A.add(student1);
        System.out.println("录入成功！");

    }

    public static void CheckStudent(ArrayList<Student> list) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s1 = new Student("l", "01", " 男", 18);
        ArrayList<Student> newlist = new ArrayList<>();


        //初始参数：
        newlist.add(s1);


        //选择菜单：
        wc:
        while (true) {
            ShowMenu();
            int a = scanner.nextInt();
            switch (a) {
                //添加
                case 1: {
                    nc1:
                    while (true) {
                        addStudent(newlist);
                        nc2:
                        while (true) {
                            System.out.println("如要继续请按 y，,如要结束添加，请输入n ");
                            String b1 = scanner.next();
                            if (b1.equals("n")) {
                                continue wc;
                            } else if (b1.equals("y")) {
                                continue nc1;
                            } else {
                                System.out.println("输出信息无法识别，请输入y/n");
                                continue nc2;
                            }
                        }
                    }

                }
                case 2: {
                    showStudent(newlist);
                    break ;
                }
                case 3: {
                    nc1:
                    while (true) {
                        System.out.println("-------请输入你要修改的学号-------");
                        String id = scanner.next();
                        boolean b = panDuan(newlist, id);
                        if (b == true) {
                            changeStudent(newlist, id);
                            nc2:while (true) {
                                System.out.println("如要继续请按 y，,如要结束添加，请输入n ");
                                String b1 = scanner.next();
                                if (b1.equals("y")) {
                                    continue nc1;
                                } else if (b1.equals("n")) {
                                    continue wc;
                                }else {
                                    System.out.println("输入信息无法识别，请输入y/n");
                                    continue nc2;
                                }
                            }
                        } else {
                            System.out.println("此学号不存在，请重新输入：");
                            continue nc1;
                        }
                    }

                }
                case 4: {

                    nc1:
                    while (true) {
                        System.out.println("-------请输入你要删除的学号-------");
                        String id = scanner.next();
                        boolean b = panDuan(newlist, id);

                        if (b == true) {
                            deleteStudent(newlist, id);
                            nc2:while (true) {
                                System.out.println("如要继续请按 y，,如要结束添加，请输入n ");
                                String b1 = scanner.next();
                                if (b1.equals("y")) {
                                    continue nc1;
                                } else if (b1.equals("n")) {
                                    continue wc;
                                } else {
                                    System.out.println("输入信息无法识别，请输入y/n");
                                    continue nc2;
                                }
                            }

                        } else {
                            System.out.println("此学号不存在，请重新输入：");
                            continue nc1;
                        }
                    }
                }
                case 5: {
                    exit();
                }
                default:{
                    System.out.println("请输入指定的数值：");
                    break ;
                }

            }
        }

    }


    public static void changeStudent(ArrayList<Student> list_A, String id) {
        Scanner s1 = new Scanner(System.in);

        for (int i = 0; i < list_A.size(); i++) {
            Student s = list_A.get(i);
            if (id.equals(s.getId())) {
                System.out.println("请输入修改的姓名：");
                String name = s1.next();
                System.out.println("请输入修改的学号：");
                String id1 = s1.next();
                System.out.println("请输入修改的性别：");
                String sex = s1.next();
                System.out.println("请输入修改的年龄：");
                int age = s1.nextInt();

                Student student = new Student(name, id1, sex, age);
                list_A.set(i, student);
                System.out.println("修改成功！");
                return;
            }
        }

    }


    public static void deleteStudent(ArrayList<Student> list_A, String id) {
        Scanner s1=new Scanner(System.in);
        for (int i = 0; i < list_A.size(); i++) {
            Student s=list_A.get(i);
            if (id.equals(s.getId())){
                list_A.remove(s);
                System.out.println("删除成功！");
                return;
            }
        }

    }


    public static void showStudent(ArrayList<Student> list_A) {

        if (list_A.size() == 0) {
            System.out.println("当前无学生信息，请先录入！ ");
            return;
        }
        System.out.println("姓名\t\t学号\t\t性别\t\t年龄");
        for (int i = 0; i < list_A.size(); i++) {
            Student student = list_A.get(i);
            System.out.println(student.getName() + "\t\t" + student.getId() + "\t\t" + student.getSex() + "\t\t" + student.getAge());
        }

    }

    public static boolean panDuan(ArrayList<Student> list_A, String id) {
        for (int i = 0; i < list_A.size(); i++) {
            Student s = list_A.get(i);
            if (id.equals(s.getId())) {
                return true;
            }
        }
        return false;
    }

    public static void exit() {
        System.out.println("感谢您的使用！");
        System.exit(0);
    }

}


