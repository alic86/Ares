package com.alic.netty.client;

import com.alic.netty.AbstractDelimeterChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author suxingzhe
 * @create 2018-06-20 下午4:34
 **/
public class DelimeterClientChannelInitializer extends AbstractDelimeterChannelInitializer {
    @Override
    public void addHandler(SocketChannel socketChannel){
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }
}
