package basic;

public class ProducerCustomerDemo {
    public static void main(String[] args) {

        Food food = new Food();
        Producer p = new Producer(food);
        Customer c = new Customer(food);

        Thread threadProducer = new Thread(p);
        Thread threadCustomer = new Thread(c);

        threadProducer.start();
        threadCustomer.start();
    }
}

class Producer implements Runnable {
    private Food food;

    public Producer(Food food) {
        this.food = food;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                food.set("菜1", "111111");
            } else {
                food.set("菜2", "2222222");
            }
        }
    }
}

class Customer implements Runnable {

    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}

class Food {
    String name;
    String desc;
    private boolean flag = true;//true: produce; false: custome

    public synchronized void set(String name, String desc) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;
        this.notify();
    }

    public synchronized void get() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "->" + this.getDesc());
        flag = true;
        this.notify();
    }

    public Food() {
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}