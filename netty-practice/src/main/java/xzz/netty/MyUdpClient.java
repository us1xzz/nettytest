package xzz.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MyUdpClient {
    //public static final int MessageReceived = 0x99;
    private static int scanPort = 9999;
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST,true)
                    .handler(new UdpClientHadler());
            Channel ch = bootstrap.bind(0).sync().channel();
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("来自客户端：我是客户端", CharsetUtil.UTF_8),
                    new InetSocketAddress("127.0.0.1",scanPort))).sync();
            ch.closeFuture().await();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }
}
