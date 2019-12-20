package cn.snowpic.year_2019.day_09_23;

import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/23 20:33
 **/

public class GenericTest {

    /**
     * bridge pattern
     * @author lf
     * @time 2019/9/23 20:34
     */
    @Test
    public void test1(){
        MyCountry country0 = new MyCountry(new GreenBridge());
        MyCountry country1 = new MyCountry(new YellowBridge());

        country0.ShowPower();
        country1.ShowPower();
    }
}

class MyCountry{
    private Bridge bridge;

    public MyCountry(Bridge bridge) {
        this.bridge = bridge;
    }

    void ShowPower(){
        bridge.showColor();
    }
}

interface Bridge{
    void showColor();
}

class GreenBridge implements Bridge{
    @Override
    public void showColor() {
        System.out.println("Green bridge");
    }
}

class YellowBridge implements Bridge{
    @Override
    public void showColor() {
        System.out.println("Yellow bridge");
    }
}
