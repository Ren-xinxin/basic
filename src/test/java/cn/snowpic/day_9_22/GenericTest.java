package cn.snowpic.day_9_22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

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

class ProductIterator implements Iterator<Product>,Iterable<Product> {

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