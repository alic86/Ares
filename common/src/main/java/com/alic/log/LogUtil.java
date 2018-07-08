package com.alic.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具抽象类
 *
 * @author suxingzhe
 * @create 2018-05-09
 **/
public abstract class LogUtil {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
