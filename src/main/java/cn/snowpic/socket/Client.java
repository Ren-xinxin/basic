package cn.snowpic.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.stream.Stream;

/**
 * @className Client
 * @description
 * @author lf
 * @time 2019/8/29 23:59
 **/

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9090);
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);
    }
}
