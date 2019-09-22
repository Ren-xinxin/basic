package cn.snowpic.day_9_22;

import org.junit.Test;

import java.util.ArrayList;
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