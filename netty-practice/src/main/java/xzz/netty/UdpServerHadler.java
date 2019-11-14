package xzz.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

public class UdpServerHadler extends SimpleChannelInboundHandler<DatagramPacket>{
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        //做类型转换，将msg转换成Netty的ByteBuf对象。
        //ByteBuf类似于JDK中的java.nio.ByteBuffer 对象，不过它提供了更加强大和灵活的功能
        ByteBuf buf = packet.copy().content();
        System.out.println("buf:"+buf);
        //通过ByteBuf的readableBytes方法可以获取缓冲区可读的字节数，
        //根据可读的字节数创建byte数组
        byte[] req = new byte[buf.readableBytes()];
        System.out.println("req:"+req);
        //通过ByteBuf的readBytes方法将缓冲区中的字节数组复制到新建的byte数组中
        buf.readBytes(req);
//        //通过new String构造函数获取请求消息。
//        String body = new String(req,"UTF-8");
//        System.out.println("body:"+ body);
        //Log.d("TAG,body")
        String string = StringHexUtil.BytesToString(req);
        System.out.println(string);//打印收到的信息

        //向客户端发送消息
        String json = "端=";
        byte[] bytes = json.getBytes("UTF-8");
        //System.out.println();
        DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), packet.sender());
        ctx.writeAndFlush(data); //向客户端发送消息


    }
}
