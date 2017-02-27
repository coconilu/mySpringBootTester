package dev.wangyaohui.aop;

import dev.wangyaohui.tools.Counting;
import org.springframework.stereotype.Component;

/**
 * Created by wangyaohui on 2017/2/27.
 */
@Component
public class CountingTester {
    @Counting
    public void counted() {
        System.out.println("被计算时长的方法");
    }
}
