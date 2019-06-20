package basic;

/*
 *对修改关闭，对扩展开放
 * 两个插线板PowerA和PowerB，两个对应的插头PowerAImp和PowerBImp，
 * 插头B不能插到PowerA中，现在加一个adapter，使B能插到A插线板中。
 *
 * */
public class AdapterDemo {
    public static void main(String[] args) {
        AdapterDemo demo = new AdapterDemo();
        PowerA powerA = new PowerAImp();
        demo.work(powerA);

        PowerB powerB = new PowerBImp();

        //if no adapter work(powerB) fail

        //adapter方式
        Adapter adapter = new Adapter(powerB);
        demo.work(adapter);

    }

    public void work(PowerA power) {
        System.out.println("start");
        power.insert();
        System.out.println("end");
    }
}

interface PowerA {
    void insert();
}

class PowerAImp implements PowerA {
    public void insert() {
        System.out.println("power a is working");
    }
}

interface PowerB {
    void connect();
}

class PowerBImp implements PowerB {
    public void connect() {
        System.out.println("power b is working");
    }
}

class Adapter implements PowerA {
    private PowerB powerB;

    public Adapter(PowerB powerB) {
        this.powerB = powerB;
    }

    public void insert() {
        powerB.connect();
    }
}


/*
 * 另一种形式
 * */
interface Animal {
    void run();

    void swim();

    void jump();
    //...
}

//此时Dog要把Animal中各种方法都实现，但是Dog只需要run，其他不需要
//class Dog implements Animal{
//
//}

//可以看成另一种形式的adapter
//把Animal中的所有方法进行空实现
abstract class AnimalFunction implements Animal {
    public void run() {
    }

    public void swim() {
    }

    public void jump() {
    }
}

class Dog extends AnimalFunction {
    public void run() {
        System.out.println("dog is running");
    }
}