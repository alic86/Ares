package com.alic.netty.server;

import com.alic.netty.AbstractDelimeterChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author suxingzhe
 * @create 2018-06-20 下午4:32
 **/
public class DelimeterServerChannelInitializer extends AbstractDelimeterChannelInitializer {
    @Override
    public void addHandler(SocketChannel socketChannel){
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}
