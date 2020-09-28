package com.demo.enums;

/**
 * @Description 枚举
 * @Author zouyuxiao
 * @Date 2020-09-28 10:48
 */

public enum EnumTest02 {

    /*用法一：常量
    在JDK1.5 之前，我们定义常量都是： public static final.... 。
    有了枚举，可以把相关的常量分组到一个枚举类型里，而且枚举提供了比常量更多的方法。     */

    RED, GREEN, BLANK, YELLOW;

    /*用法二：switch
    JDK1.6之前的switch语句只支持int,char,enum类型，
    使用枚举，能让我们的代码可读性更强。 */
    enum Signal {
        GREEN, YELLOW, RED
    }

    public class TrafficLight {
        Signal color = Signal.RED;
        public void change() {
            switch (color) {
                case RED:
                    color = Signal.GREEN;
                    break;
                case YELLOW:
                    color = Signal.RED;
                    break;
                case GREEN:
                    color = Signal.YELLOW;
                    break;
            }
        }
    }

    /*用法三：向枚举中添加新方法
    如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。*/
    public enum Color {
        RED("红色", 1),
        GREEN("绿色", 2),
        BLANK("白色", 3),
        YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (Color c : Color.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

    /*用法四：覆盖枚举的方法
    下面给出一个toString()方法覆盖的例子。 */
    public enum Color02 {
        RED("红色", 1),
        GREEN("绿色", 2),
        BLANK("白色", 3),
        YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;

        // 构造方法
        private Color02(String name, int index) {
            this.name = name;
            this.index = index;
        }

        //覆盖方法
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }
    }

    /*用法五：实现接口
    所有的枚举都继承自java.lang.Enum类。
    由于Java 不支持多继承，所以枚举对象不能再继承其他类。 */

    public interface Behaviour {
        void print();
        String getInfo();
    }
    public enum Color03 implements Behaviour{
        RED("红色", 1),
        GREEN("绿色", 2),
        BLANK("白色", 3),
        YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private Color03(String name, int index) {
            this.name = name;
            this.index = index;
        }
        //接口方法
        @Override
        public String getInfo() {
            return this.name;
        }
        //接口方法
        @Override
        public void print() {
            System.out.println(this.index+":"+this.name);
        }
    }


    /*用法六：使用接口组织枚举*/
    public interface Food {
        enum Coffee implements Food{
            BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
        }
        enum Dessert implements Food{
            FRUIT, CAKE, GELATO
        }

        static void testImplementsInterface() {
            for (Food.Dessert dessertEnum : Food.Dessert.values()) {
                System.out.print(dessertEnum + "  ");
            }
            System.out.println();
            //我这地方这么写，是因为我在自己测试的时候，把这个coffee单独到一个文件去实现那个food接口，而不是在那个接口的内部。
            for (Coffee coffee : Coffee.values()) {
                System.out.print(coffee + "  ");
            }
            System.out.println();
            //搞个实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，这么干，在写代码的时候，就很方便调用啦。
            //还有就是个“多态”的功能吧，
            Food food = Food.Dessert.CAKE;
            System.out.println(food);
            food = Coffee.BLACK_COFFEE;
            System.out.println(food);
        }
    }
    /**
     * 测试继承接口的枚举的使用
     */
    /*
        private static void testImplementsInterface() {
            for (Food.DessertEnum dessertEnum : Food.DessertEnum.values()) {
                System.out.print(dessertEnum + "  ");
            }
            System.out.println();
            //我这地方这么写，是因为我在自己测试的时候，把这个coffee单独到一个文件去实现那个food接口，而不是在那个接口的内部。
            for (CoffeeEnum coffee : CoffeeEnum.values()) {
                System.out.print(coffee + "  ");
            }
            System.out.println();
            //搞个实现接口，来组织枚举，简单讲，就是分类吧。如果大量使用枚举的话，这么干，在写代码的时候，就很方便调用啦。
            //还有就是个“多态”的功能吧，
            Food food = Food.DessertEnum.CAKE;
            System.out.println(food);
            food = CoffeeEnum.BLACK_COFFEE;
            System.out.println(food);
        }
    */
    public static void main(String[] args) {

    }
}


