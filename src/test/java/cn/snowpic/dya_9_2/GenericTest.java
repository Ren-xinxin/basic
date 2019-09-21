package cn.snowpic.dya_9_2;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.junit.Test;

/**
 * @className GenericTest
 * @description
 * @author lf
 * @time 2019/9/2 20:18
 **/

public class GenericTest {

    @Test
    public void test1() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        ChannelFuture sf = bootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ServerHandler());
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true)
                .bind(8761)
                .sync();

        sf.channel().closeFuture().sync();

        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    @Test
    public void test2() throws InterruptedException {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        ChannelFuture cf = bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true)
                .connect("127.0.0.1", 8761)
                .sync();

        cf.channel().writeAndFlush(Unpooled.copiedBuffer("hello".getBytes()));

        cf.channel().closeFuture().sync();

        workGroup.shutdownGracefully();
    }
}

class ServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String s = new String(bytes);
        System.out.println("receive some message from client " + s);
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hiii".getBytes())).addListener(ChannelFutureListener.CLOSE);
    }
}

class ClientHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;

        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String s = new String(bytes);
        System.out.println("receive some message from server " + s);
       /* ctx.channel()
                .writeAndFlush(Unpooled.copiedBuffer("hi server".getBytes()))
                .addListener(ChannelFutureListener.CLOSE);*/
    }
}