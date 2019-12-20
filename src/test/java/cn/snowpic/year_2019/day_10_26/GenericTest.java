/*
 * Copyright(c) snowpic.cn 2019-2019.All rights reserved.
 */

package cn.snowpic.year_2019.day_10_26;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/10/26 12:54
 */
public class GenericTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTest.class);

    @Test
    public void test1() throws Exception {
        Config config = new Config() {{
            setNumWorkers(2);
            setDebug(false);
        }};

        TopologyBuilder builder = new TopologyBuilder() {{
            setSpout("spout", new PwSpout());
            setBolt("print", new PrintBolt()).shuffleGrouping("spout");
            setBolt("write", new WriteBolt()).shuffleGrouping("print");
        }};

        // local cluster mode
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("topology1", config, builder.createTopology());

        // release resource
        TimeUnit.SECONDS.sleep(20);
        cluster.killTopology("topology1");
        cluster.shutdown();
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("..." + (System.currentTimeMillis() - t0));
        long t1 = System.currentTimeMillis();
        /*list.stream().sorted().forEach(s -> {
        });*/
        list.parallelStream().sorted().forEach(LOGGER::info);
        System.out.println("System.currentTimeMillis()-t1 = " + (System.currentTimeMillis() - t1));
    }
}

class PwSpout extends BaseRichSpout {

    private static final Logger LOGGER = LoggerFactory.getLogger(PwSpout.class);

    private SpoutOutputCollector collector;

    @Override
    public void open(Map<String, Object> map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        // init collector
        this.collector = spoutOutputCollector;
        LOGGER.error("init collector...");
    }

    @Override
    public void nextTuple() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // emit a integer value of range from 0 to 10
        collector.emit(new Values(new SecureRandom().nextInt(10) + ""));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("print"));
    }
}

class PrintBolt extends BaseBasicBolt {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintBolt.class);

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String print = tuple.getStringByField("print");
        LOGGER.error("print = " + print);

        basicOutputCollector.emit(new Values(print));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("write"));
    }
}

class WriteBolt extends BaseBasicBolt {

    private static final Logger LOGGER = LoggerFactory.getLogger(WriteBolt.class);

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String write = tuple.getStringByField("write");
        LOGGER.error("write = " + write);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        //outputFieldsDeclarer.declare(new Fields("write"));
    }
}
