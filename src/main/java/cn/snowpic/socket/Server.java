package cn.snowpic.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @className Server
 * @description
 * @author lf
 * @time 2019/8/29 23:54
 **/

public class Server {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket accept = serverSocket.accept();

        pool.submit(()->{
            try {
                OutputStream outputStream = accept.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                bufferedWriter.write("ssss");
                bufferedWriter.newLine();
                bufferedWriter.write("ppp");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
