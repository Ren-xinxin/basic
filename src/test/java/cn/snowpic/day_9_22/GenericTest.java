package cn.snowpic.day_9_22;

import org.junit.Test;

import java.util.ArrayList;
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