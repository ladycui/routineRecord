
package basic;

public class FactoryDemo {
    public static void main(String[] args) {
        /*原来的方式
         * 当Product改变时，phone的使用可能会受影响
         * */
//        Product phone = new Phone();
//        phone.work();

        /*工厂模式*/
        Product phone = ProductFactory.getProduct("phone");
        if (phone != null) {
            phone.work();
        }
    }
}

class ProductFactory {
    public static Product getProduct(String name) {
        if ("phone".equals(name)) {
            return new Phone();
        } else if ("computer".equals(name)) {
            return new Computer();
        }
        return null;
    }
}

interface Product {
    void work();
}

class Phone implements Product {
    public void work() {
        System.out.println("phone");
    }
}

class Computer implements Product {
    public void work() {
        System.out.println("computer");
    }
}