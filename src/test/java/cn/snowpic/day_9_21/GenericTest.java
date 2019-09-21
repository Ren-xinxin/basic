package cn.snowpic.day_9_21;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/21 13:20
 **/

public class GenericTest {

    @Test
    public void test1() {
        People jack = new People(0, true, "Jack");
        People tom = new People(0, false, "Tom");
        People bob = new People(5000, false, "Bob");

        Proxy p1 = new Proxy(jack);
        Proxy p2 = new Proxy(tom);
        Proxy p3 = new Proxy(bob);

        p1.buyCar();
        p2.buyCar();
        p3.buyCar();
    }

    @Test
    public void test2() {
        Singer weiJin = new WeiJin();
        Singer proxy = new ProxySinger(weiJin);

        proxy.sing();
    }

    @Test
    public void test3() {
        A a = new A();
    }

    /**
     * Component design pattern
     * @author lf
     * @time 2019/9/21 18:10
     */
    @Test
    public void test4() {
        Component root = new Composite("root");
        root.add(new Leaf("leaf1"));
        root.add(new Leaf("leaf2"));
        root.add(new Composite("composite1"));
        Composite composite2 = new Composite("composite2");
        composite2.add(new Leaf("leaf99"));
        composite2.operation();
        root.add(composite2);
        root.operation();
        System.out.println(root);
    }
}

interface Component {
    void operation();

    void add(Component c);

    void remove(Component c);

    Component getChild(int index);
}

class Composite implements Component {
    private String name;

    private List<Component> child = new ArrayList<>();

    private int a = 4;

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println(String.format("Composite %s is operating..", this.name));
    }

    @Override
    public void add(Component c) {
        child.add(c);
    }

    @Override
    public void remove(Component c) {
        child.remove(c);
    }

    @Override
    public Component getChild(int index) {
        return child.get(index);
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + "\"" +
                ",\"child\":" + child +
                ",\"a\":" + a +
                "}";
    }
}

class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println(String.format("Leaf %s is operating ", this.name));
    }

    @Override
    public void add(Component c) {
        System.out.println("Leaf can't add child..");
    }

    @Override
    public void remove(Component c) {
        System.out.println("Leaf can't remove child...");
    }

    @Override
    public Component getChild(int index) {
        return null;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + "\"" +
                "}";
    }
}

class A {
    private void m1() {
    }
}

interface Singer {
    void sing();
}

class WeiJin implements Singer {
    @Override
    public void sing() {
        System.out.println("WeiJin is singing...");
    }
}

class ProxySinger implements Singer {

    private Singer singer;

    public ProxySinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("Say hello to Ren Xinxin before singing..");
        singer.sing();
        System.out.println("Send a kiss to Ren Xinxin after singing...");
    }
}

interface Buy {
    void buyCar();
}

class Proxy implements Buy {

    private People people;

    public Proxy(People people) {
        this.people = people;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public void buyCar() {
        if (this.people.isVip()) {
            System.out.println(this.people.getName() + " is VIP, have buy a car");
            return;
        }
        if (this.people.getCash() >= 5000) {
            System.out.println(this.people.getName() + " have buy a car");
        } else {
            System.out.println(this.people.getName() + " doesn't have enough money to buy a car");
        }
    }
}

class People {

    public People(int cash, boolean isVip, String name) {
        this.cash = cash;
        this.isVip = isVip;
        this.name = name;
    }

    private int cash;
    private boolean isVip;

    private String name;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isVip() {
        return isVip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}

