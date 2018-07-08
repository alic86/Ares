package com.alic.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author suxingzhe
 * @create 2018-06-20 上午11:20
 **/
public abstract class AbstractChannelInitializer extends ChannelInitializer<SocketChannel> {
    protected abstract void addDecoder(SocketChannel socketChannel, ByteBuf delimiter);

    public abstract void addHandler(SocketChannel socketChannel);

    @Override
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
        addDecoder(socketChannel, delimiter);
        socketChannel.pipeline().addLast(new StringDecoder());
        addHandler(socketChannel);
    }
}
