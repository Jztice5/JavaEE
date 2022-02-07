package P_A;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jztice5
 * @date 2022年01月19日 14:33
 */

//

public class StudentManager {
    //显示首页方法
    public static void ShowMenu() {
        System.out.println("-----欢迎使用学生管理系统-----");
        System.out.println("1，添加学生");
        System.out.println("2，删除学生");
        System.out.println("3，修改学生");
        System.out.println("4，查看所有学生");
        System.out.println("5，退出系统");

    }

    //添加的方法：
    //数据放到集合内：所以参数要为集合
    //list集合
    public static void addList(ArrayList<Student> list) {
        Scanner se2 = new Scanner(System.in);

        //传值
        String id ;
        while (true) {
            System.out.println("输入学号：");
            id= se2.nextLine();
            //判断学号是否存在
            //调用判断是否存在的方法
            Boolean p = panDuan(list, id);
            if (p) {
                showPan();
                //如果存在则直接结束添加的方法。
            }else {
                break ;
            }
        }
        System.out.println("输入学生姓名：");
        String name = se2.next();
        System.out.println("输入学生年龄：");
        String age = se2.next();
        System.out.println("输入学生住址：");
        //注意这里的输入别用 nextLine，否则直接跳过。
        String address = se2.next();

        //！！！创建对象，保存键盘录入的信息到Student类,并获取然后放到集合list中
        //利用参数传递
        Student s = new Student(id, name, age, address);

        list.add(s);
        System.out.println("录入成功!");

    }

    //查看所有学生信息
    public static void ShowList(ArrayList<Student> list01) {
        if (list01.size() == 0) {
            System.out.println("当前无学生信息，请先录入");
            return;
        }

        System.out.println("学号\t\t姓名\t\t年龄\t\t住址");
        for (int i = 0; i < list01.size(); i++) {
            //定义一个对象去接收集合遍历的数据
            Student student = list01.get(i);
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getAge() + "岁" + "\t" + student.getAddress() + "\t");
        }
    }

    //修改学生信息：!!!
    public static void ChangeList(ArrayList<Student> list02, String id) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < list02.size(); i++) {
            Student s = list02.get(i);
            //判断输入的id是否和遍历过程的id相同
            if (id.equals(s.getId())) {
                System.out.println("请输入学生的新姓名：");
                String name = scanner.next();
                System.out.println("请输入学生的新年龄：");
                String age = scanner.next();
                System.out.println("请输入学生的新住址：");
                String address = scanner.next();

                Student student = new Student(id, name, age, address);
                list02.set(i, student);
                System.out.println("修改成功！");
                return;
            }
        }

    }


    //对学号是否存在进行判断
    public static boolean panDuan(ArrayList<Student> list03, String str) {
        for (int i = 0; i < list03.size(); i++) {
            Student s = list03.get(i);
            if (str.equals(s.getId())) {
                return true;
            }
        }
        return false;
    }


    //删除
    public static void removeList(ArrayList<Student> list04) {
        Scanner s1 = new Scanner(System.in);

        System.out.println("-----请输入你要删除的学生学号-----");
        String s = s1.next();

        for (int i = 0; i < list04.size(); i++) {
            Student student = list04.get(i);
            if (s.equals(student.getId())) {
                list04.remove(i);
                System.out.println("删除成功!");
                return;     //return作为在无返回值的方法体结束符
            }
        }
        //如果程序运行到这里，证明学号不存在！
        System.out.println("你输入的学号不存在，请重新输入： ");
    }


    //输出不存在的学号
    public static void ShowWrong01() {
        System.out.println("你输入的学号不存在请重新输入：");
    }


    //main
    public static void main(String[] args) {
        //创建Scanner扫描器
        Scanner se = new Scanner(System.in);
        Student s1 = new Student();
        //创建List集合,放到循环外面，保证只有一个集合
        ArrayList<Student> MenuList = new ArrayList<>();

        /*
         *   添加测试数据
         * */

        Student student1 = new Student("001", "阿达", "28", "广州");
        MenuList.add(student1);

        //循环输入信息：
        wc:
        while (true) {
            //先展示菜单
            ShowMenu();
            //选择功能：
            System.out.println("选择功能：");
            int a = se.nextInt();

            switch (a) {

                case 1: {
                    System.out.println("添加学生信息:");
                    while (true) {
                        addList(MenuList);
                        System.out.println("如要继续请按1，,如要结束添加，请输入end");
                        String b = se.next();
                        //判断是否要继续输入
                        if ("end".equals(b)) {
                            continue wc;
                        } else {
                            continue;
                        }
                    }
                }

                case 2: {
                    System.out.println("删除学生信息");
                    while (true) {
                        removeList(MenuList);

                        System.out.println("如要继续请按1，,如要结束添加，请输入end");
                        String b = se.next();
                        //判断是否要继续输入
                        if (b.equals("end")) {
                            continue wc;
                        } else {
                            continue;
                        }
                    }

                }

                case 3: {
                    System.out.println("修改学生信息");
                    while (true) {
                        System.out.println("-----请输入你要修改的学生学号-----");
                        String str = se.next();
                        //调用判断是否存在的方法
                        Boolean p = panDuan(MenuList, str);
                        //如果为true则调用修改方法

                        if (p == true) {
                            ChangeList(MenuList, str);
                            System.out.println("如要继续请按1，,如要结束添加，请输入end");
                            String b = se.next();
                            if (b.equals("end")) {
                                continue wc;
                            } else {
                                continue;
                            }
                        } else if (p == false) {
                            ShowWrong01();
                            System.out.println("如要继续请按1，,如要结束添加，请输入end");
                            String b = se.next();
                            if ("end".equals(b)) {
                                continue wc;
                            } else {
                                continue;
                            }
                        }
                    }
                }

                case 4: {
                    System.out.println("查看所有学生信息");
                    ShowList(MenuList);
                    break;
                }

                case 5: {
                    System.out.println("感谢你的使用");
                    //因为没有循环所以这里的return是结束当前整个方法体（相当于结束main）达到退出系统的目的
                    return;
                }

                //default，如出现与case值对于不上的值时则执行这个default的方法。
                default: {
                    System.out.println("您输入的信息无效，请重新输入：");
                }
            }
        }
    }

    private static void showPan() {
        System.out.println("你输入的学号已存在，请重新输入！");
    }
}
