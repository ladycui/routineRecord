package basic;

public class ProxyDemo {
    public static void main(String[] args) {

        Action user = new UserAction();
        ActionProxy proxy = new ActionProxy(user);
        proxy.action();
    }
}


interface Action {
    void action();
}

class UserAction implements Action {
    public void action() {
//        for (int i = 0; i < 1000; i++) {
        System.out.println("user is doing this action");
//        }
    }
}

class ActionProxy implements Action {
    private Action target;//被代理的对象

    public ActionProxy(Action target) {
        this.target = target;
    }

    @Override
    public void action() {
        //do something else, e.g. compute the action time
        long start = System.currentTimeMillis();

        target.action();

        //do something else
        long end = System.currentTimeMillis();
        System.out.println("this action takes " + (end - start));
    }
}