package cn.snowpic.year_2019.month_09.month_09.day_01;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.junit.Test;

import java.nio.IntBuffer;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/1 12:27
 **/

public class GenericTest {

    @Test
    public void test1() {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(10);
        buffer.put(13);
        buffer.put(23);

        System.out.println("buffer = " + buffer);

        buffer.put(1, 4);

        System.out.println("buffer = " + buffer);
    }

    @Test
    public void test2() {

    }

    private static class Server {
        public static void main(String[] args) {
            // deal client connection
            NioEventLoopGroup bossGroup = new NioEventLoopGroup();
            // deal actual business logic
            NioEventLoopGroup workGroup = new NioEventLoopGroup();

            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(new ServerHandler());
                            }
                        })
                        // connection buffer
                        //.option(ChannelOption.SO_BACKLOG, 128)
                        // keep alive
                        .option(ChannelOption.SO_KEEPALIVE, true);
                // bind port and start listening
                ChannelFuture sync = bootstrap.bind(8761).sync();
                //sync.channel().writeAndFlush(Unpooled.copiedBuffer("server send message ,hello".getBytes()));

                // make main thread block
                sync.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                bossGroup.shutdownGracefully();
                workGroup.shutdownGracefully();
            }
        }


    }

    private static class Client {
        public static void main(String[] args) {
            // deal actual business logic
            NioEventLoopGroup workGroup = new NioEventLoopGroup();

            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(workGroup)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(new ClientHandler());
                            }
                        })
                        // keep alive
                        .option(ChannelOption.SO_KEEPALIVE, true);
                // bind port and start listening
                ChannelFuture sync = bootstrap.connect("127.0.0.1", 8761).sync();

                sync.channel().writeAndFlush(Unpooled.copiedBuffer("client send message,yoooo~".getBytes()));

                sync.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                workGroup.shutdownGracefully();
            }
        }
    }
}

class ServerHandler extends ChannelHandlerAdapter {
    /**
     * exception caught
     * @author lf
     * @time 2019/9/1 16:01
     * @param ctx ctx
     * @param cause cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    /**
     * channel read
     * @author lf
     * @time 2019/9/1 16:01
     * @param ctx ctx
     * @param msg msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            String s = new String(bytes);
            System.out.println("receive client message " + s);
            ctx.channel().writeAndFlush(Unpooled.copiedBuffer("server send message".getBytes())).addListener(ChannelFutureListener.CLOSE);
        } finally {
            // release the message
            ReferenceCountUtil.release(msg);
        }
    }
}

class ClientHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            String s = new String(bytes);
            System.out.println(s);
            ctx.channel().close();
        } finally {
            // release the message
            ReferenceCountUtil.release(msg);
        }
    }
}


