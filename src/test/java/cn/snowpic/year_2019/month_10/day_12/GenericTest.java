package cn.snowpic.year_2019.month_10.day_12;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.*;

/**
 * @author lf
 * @className GenericTest
 * @description
 * @time 2019/10/12 22:38
 */
public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2019/10/12 22:40
     */
    @Test
    public void test1() throws Exception {
        int SESSION_TIME_OUT = 10000;
        String CONNECT_STRING = "192.168.20.123:2181,192.168.20.121:2181,192.168.20.122:2181";
        CountDownLatch connectedSemaphore = new CountDownLatch(1);
        long start = System.currentTimeMillis();
        ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, SESSION_TIME_OUT, event -> {
            Watcher.Event.KeeperState state = event.getState();
            Watcher.Event.EventType type = event.getType();
            if (Watcher.Event.KeeperState.SyncConnected == state) {
                if (Watcher.Event.EventType.None == type) {
                    System.out.println("zk connected");
                    connectedSemaphore.countDown();
                }
            }
        });

        // 你好呀
        connectedSemaphore.await();

        // zooKeeper.create("/rxx", "new bee".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);,

        zooKeeper.setData("/rxx", "I am god...".getBytes(), -1);
        byte[] data = zooKeeper.getData("/rxx", event -> {

        }, new Stat());
        System.out.println(new String(data));
        System.out.println("finished..");
        System.out.println(String.format(Locale.ENGLISH, "time cost %s", (System.currentTimeMillis() - start)));


        zooKeeper.close();
    }

    /**
     * zkClient
     *
     * @author lf
     * @time 2019/10/13 20:41
     */
    @Test
    public void test2() {
        ZkClient client = new ZkClient(new ZkConnection("192.168.20.121:2181"), 20000);
        // 递归创建
        // client.createPersistent("/rxx/good/error", true);

        // delete recursive
        // client.deleteRecursive("/rxx");

        client.createPersistent("/rxx", "333");

        Object data = client.readData("/rxx");
        System.out.println(data);

        client.close();

    }

    /**
     * semaphore
     *
     * @author lf
     * @time 2019/10/13 21:32
     */
    @Test
    public void test3() throws InterruptedException {
        // 主要用于限流
        // 最多3个线程可以获取许可
        Semaphore semaphore = new Semaphore(3);

        ExecutorService pool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                SecureRandom random = new SecureRandom();
                try {
                    semaphore.acquire();
                    System.out.println("acquired...");
                    TimeUnit.SECONDS.sleep(random.nextInt(3));
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(10000);
    }
}
