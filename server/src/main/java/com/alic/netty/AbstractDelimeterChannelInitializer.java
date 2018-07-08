package com.alic.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;

/**
 * @author suxingzhe
 * @create 2018-06-20 上午11:28
 **/
public abstract class AbstractDelimeterChannelInitializer extends AbstractChannelInitializer {
    @Override
    public void addDecoder(SocketChannel socketChannel, ByteBuf delimiter){
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
    }
}
