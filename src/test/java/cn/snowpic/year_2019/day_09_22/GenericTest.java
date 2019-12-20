package cn.snowpic.year_2019.day_09_22;

import org.junit.Test;

import javafx.scene.paint.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/22 12:27
 **/

public class GenericTest {

    /**
     * watcher design pattern
     * @author lf
     * @time 2019/9/22 12:27
     */
    @Test
    public void test1() {
        Watcher guarder = new Guarder();
        Watcher evildoer = new Evildoer();

        Watched watched = new Transport();
        watched.addWatcher(guarder);
        watched.addWatcher(evildoer);

        watched.notifyAllWatchers();
    }

    /**
     * iterator design pattern
     * @author lf
     * @time 2019/9/22 12:50
     */
    @Test
    public void test2() {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("hat"));
            add(new Product("paper"));
            add(new Product("pen"));
            add(new Product("mouse"));
        }};

        ProductIterator iterator = new ProductIterator(products);

        for (Product product : iterator) {
            System.out.println(product);
        }
    }

    /**
     * command design pattern
     * @author lf
     * @time 2019/9/22 14:54
     */
    @Test
    public void test4() {
        Tv tv = new Tv();
        Command on = new CommandOn(tv);
        Command off = new CommandOff(tv);
        Command change = new CommandChannelChange(tv);
        on.execute();
        change.execute();
        off.execute();
    }

    /**
     * memento design pattern
     * @author lf
     * @time 2019/9/22 15:29
     */
    @Test
    public void test5() {
        Person tom = new Person("Tom", 11, 170.1, 63.0);
        System.out.println("tom = " + tom);
        Caretaker caretaker = new Caretaker(tom.createMemento());
        tom.setAge(18);
        tom.setHeight(18);
        System.out.println("tom = " + tom);

        tom.restore(caretaker.getMemento());
        System.out.println("tom = " + tom);

    }

    /**
     * state design pattern
     * @author lf
     * @time 2019/9/22 18:02
     */
    @Test
    public void test6() {
        Context context = new Context(Color.PURPLE);
        State state1 = context.pull();
        System.out.println("state1 = " + state1);
        State state2 = context.push();
        System.out.println("state2 = " + state2);
    }

    /**
     * visitor design pattern
     * @author lf
     * @time 2019/9/22 18:02
     */
    @Test
    public void test7() {
        Element elementA = new ElementA();
        Element elementB = new ElementB();

        IVisit visitor = new Visitor();

        elementA.accept(visitor);
        elementB.accept(visitor);
    }

}

interface Element {
    void accept(IVisit visit);

    void doSomething();
}

class ElementA implements Element {
    @Override
    public void accept(IVisit visit) {
        visit.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("I am element A");
    }
}

class ElementB implements Element {
    @Override
    public void accept(IVisit visit) {
        visit.visit(this);
    }

    @Override
    public void doSomething() {
        System.out.println("I am element B");
    }
}

interface IVisit {
    void visit(Element element);
}

class Visitor implements IVisit {
    @Override
    public void visit(Element elementA) {
        elementA.doSomething();
    }
}

abstract class State {

    protected final List<Color> colors = Arrays.asList(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.PURPLE);

    public abstract State pull();

    public abstract State push();
}

class Context extends State {

    private Color color;

    public Context(Color color) {
        this.color = color;
    }

    @Override
    public State pull() {
        int i = colors.indexOf(color);
        int index = --i < 0 ? colors.size() - 1 : i;
        return new Context(colors.get(index));
    }

    @Override
    public State push() {
        int i = colors.indexOf(color);
        int index = ++i > colors.size() - 1 ? 0 : i;
        return new Context(colors.get(index));
    }

    @Override
    public String toString() {
        return "{" +
                "\"color\":" + color.toString() +
                "}";
    }
}

class Caretaker {
    private Person memento;

    public Caretaker(Person memento) {
        this.memento = memento;
    }

    public Person getMemento() {
        return memento;
    }

    public void setMemento(Person memento) {
        this.memento = memento;
    }
}

class Person {
    private String name;
    private int age;
    private double height;
    private double weight;

    public Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person createMemento() {
        return new Person(name, age, height, weight);
    }

    public void restore(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.height = person.height;
        this.weight = person.weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + "\"" +
                ",\"age\":" + age +
                ",\"height\":" + height +
                ",\"weight\":" + weight +
                "}";
    }
}

class CommandChannelChange implements Command {
    private Tv tv;

    public CommandChannelChange(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.channelChange();
    }
}

class CommandOff implements Command {
    private Tv tv;

    public CommandOff(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOff();
    }
}

class CommandOn implements Command {

    private Tv tv;

    public CommandOn(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOn();
    }
}

interface Command {
    void execute();
}

/**
 * command receiver
 * @className Tv
 * @author lf
 * @time 2019/9/22 14:48
 */
class Tv {
    private int channel = 0;

    public void turnOn() {
        System.out.println("television is turning on.");
    }

    public void turnOff() {
        System.out.println("television is turning off.");
    }

    public void channelChange() {
        System.out.println("television channel is changing to " + (++this.channel));
    }
}

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + "\"" +
                "}";
    }
}

class ProductIterator implements Iterator<Product>, Iterable<Product> {

    private List<Product> products;

    private int index = 0;

    public ProductIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < this.products.size();
    }

    @Override
    public Product next() {
        return this.products.get(index++);
    }

    @Override
    public Iterator<Product> iterator() {
        return this;
    }
}

class Guarder implements Watcher {
    @Override
    public void update() {
        System.out.println("guarder is watching...");
    }
}

class Evildoer implements Watcher {
    @Override
    public void update() {
        System.out.println("evildoer is watching...");
    }
}

class Transport implements Watched {

    private List<Watcher> watchers = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyAllWatchers() {
        watchers.forEach(Watcher::update);
    }
}

interface Watcher {
    void update();
}

interface Watched {
    void addWatcher(Watcher watcher);

    void removeWatcher(Watcher watcher);

    void notifyAllWatchers();
}