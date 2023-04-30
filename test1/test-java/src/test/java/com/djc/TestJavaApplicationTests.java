package com.djc;

import com.djc.mapper.AccessoriesArrivalDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: djc
 * @Date: 2023-04-29-17:13
 * @Description:
 */
@SpringBootTest(classes = TestApplication.class)
public class TestJavaApplicationTests {
    public static void main(String[] args) {
    }

    @Autowired
    AccessoriesArrivalDetailMapper accessoriesArrivalDetailMapper;

}
