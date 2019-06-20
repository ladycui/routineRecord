package basic;

/*
 * 构造方法private
 *
 * 在设计工具类时（工具被频繁调用），可以用单例模式，节省内存，提高效率
 *
 * */
public class SingleInstanceDemo {
    public static void main(String[] args) {
        Single single = Single.getInstance();
        single.method();
    }
}

//生命周期不一样：类加载时，instance被创建
class Single {
    private static Single instance = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return instance;
    }

    public void method() {
        System.out.println("single method");
    }
}

//推荐
//用时再创建instance
//多线程时存在安全问题
class Single2 {
    private static Single2 instance;

    private Single2() {
    }

    public static Single2 getInstance() {
        if (instance == null)
            instance = new Single2();
        return instance;
    }

    public void method() {
        System.out.println("single method");
    }
}