package cn.snowpic.year_2019.month_09.day_20;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/20 20:34
 **/

public class GenericTest {

    @Test
    public void test1() {
        Hamburger hamburger = new ChickenBurger();

        System.out.println("name: " + hamburger.getName());
        System.out.println("price: " + hamburger.getPrice());
        Hamburger lettuce = new Lettuce(hamburger);

        System.out.println("name: " + lettuce.getName());
        System.out.println("price: " + lettuce.getPrice());
        Hamburger chilliBurger = new Chilli(lettuce);

        System.out.println("name: " + chilliBurger.getName());
        System.out.println("price: " + chilliBurger.getPrice());
    }
}

abstract class Hamburger {
    String name;

    public String getName() {
        return this.name;
    }

    public abstract double getPrice();
}

class ChickenBurger extends Hamburger {

    ChickenBurger() {
        this.name = "chicken hamburger";
    }

    @Override
    public double getPrice() {
        return 10.00;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

abstract class Condiment extends Hamburger {
    public abstract String getName();
}

class Lettuce extends Condiment {

    private Hamburger hamburger;

    public Lettuce(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public double getPrice() {
        // lettuce is 5 yuan.
        return this.hamburger.getPrice() + 1.5;
    }

    @Override
    public String getName() {
        // name add lettuce
        return this.hamburger.getName() + " added lettuce";
    }
}

class Chilli extends Condiment {

    private Hamburger hamburger;

    public Chilli(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public double getPrice() {
        // chilli for free
        return this.hamburger.getPrice();
    }

    @Override
    public String getName() {
        // name add chilli
        return this.hamburger.getName() + " added chilli";
    }
}
