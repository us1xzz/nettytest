package xzz.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;


public class UdpClientHadler extends SimpleChannelInboundHandler<DatagramPacket> {
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        System.out.println(packet.sender().getAddress().toString()+":"+packet.sender().getPort());
        ByteBuf mainpacket = packet.content();
        //String body = packet.content().toString(CharsetUtil.UTF_8);
        int length = mainpacket.readableBytes();
        byte[] array = new byte[length];
        mainpacket.getBytes(0,array);

        String body1 = StringHexUtil.BytesToString(array);
        //接受服务端发送的数据
        System.out.println(body1);



    }



}
