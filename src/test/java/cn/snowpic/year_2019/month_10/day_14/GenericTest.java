package cn.snowpic.year_2019.month_10.month_10.day_14;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lf
 * @className GenericeTest
 * @description
 * @time 2019/10/14 21:28
 */

public class GenericTest {

    /**
     * test1
     *
     * @author lf
     * @time 2019/10/14 21:29
     */
    @Test
    public void test1() throws Exception {
        // retry policy
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(1000, 10);

        CuratorFramework build = CuratorFrameworkFactory.builder()
                .connectString("192.168.20.121:2181")
                .retryPolicy(exponentialBackoffRetry)
                .connectionTimeoutMs(10000)
                .build();
        // start connection
        build.start();

        /*build.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/rxx", "I am god..".getBytes());*/

        build.setData().inBackground((c, e) -> {
            System.out.println("e.getResultCode() = " + e.getResultCode());
            System.out.println("e.getType() = " + e.getType());
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        }).forPath("/rxx", "weijin Meng is my goddess".getBytes());
        byte[] bytes = build.getData()
                .forPath("/rxx");
        System.out.println(new String(bytes));
        // close connection
        build.close();
    }

    /**
     * curator recipes
     *
     * @author lf
     * @time 2019/10/14 22:36
     */
    @Test
    public void test2() throws Exception {
        // crate a curator framework
        CuratorFramework build = CuratorFrameworkFactory.builder()
                .connectionTimeoutMs(10000)
                .connectString("192.168.20.121:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();

        // start client
        build.start();

        /*// create a node cache
        final NodeCache cache = new NodeCache(build, "/super");
        cache.start(true);

        // add listener...
        // create & edit
        cache.getListenable().addListener(() -> {
            System.out.println("cache.getCurrentData().getPath() = " + cache.getCurrentData().getPath());
            String data = new String(cache.getCurrentData().getData());
            System.out.println("data = " + data);
            System.out.println("cache.getCurrentData().getStat() = " + cache.getCurrentData().getStat());
        });*/

        PathChildrenCache cache = new PathChildrenCache(build, "/", true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        cache.getListenable()
                .addListener((curator, event) -> {
                    switch (event.getType()) {
                        case CHILD_ADDED:
                            System.out.println("CHILD_ADDED :" + event.getData().getPath());
                            break;
                        case CHILD_UPDATED:
                            System.out.println("CHILD_UPDATED :" + event.getData().getPath());
                            break;
                        case CHILD_REMOVED:
                            System.out.println("CHILD_REMOVED :" + event.getData().getPath());
                            break;
                        default:
                    }
                    ChildData data = event.getData();
                    if (data != null) {
                        System.out.println(new String(data.getData()));
                    }
                });


        // sleeping.....
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
