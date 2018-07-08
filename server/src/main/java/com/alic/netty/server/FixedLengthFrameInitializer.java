package com.alic.netty.server;

import com.alic.netty.AbstractFixedLengthFrameInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author suxingzhe
 * @create 2018-06-20 下午5:51
 **/
public class FixedLengthFrameInitializer extends AbstractFixedLengthFrameInitializer {
    @Override
    public void addHandler(SocketChannel socketChannel) {
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}
