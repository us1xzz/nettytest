package xzz.netty;

import io.netty.bootstrap.Bootstrap;

import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;




public class MyUdpServer {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST,true) //支持广播
                    .handler(new UdpServerHadler());
            bootstrap.bind(9999).channel().closeFuture().await();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
