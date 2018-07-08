package com.alic.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

/**
 * @author suxingzhe
 * @create 2018-06-20 下午4:53
 **/
public abstract class AbstractFixedLengthFrameInitializer extends AbstractChannelInitializer {
    @Override
    public void addDecoder(SocketChannel socketChannel, ByteBuf delimiter){
        socketChannel.pipeline().addLast(new FixedLengthFrameDecoder(20));
    }
}
