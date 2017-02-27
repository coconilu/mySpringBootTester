package dev.wangyaohui;

import dev.wangyaohui.aop.CountingTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangyaohui on 2017/2/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPTests {
    @Autowired
    private CountingTester countingTester;

    @Test
    public void testAOP() {
        countingTester.counted();
    }
}
