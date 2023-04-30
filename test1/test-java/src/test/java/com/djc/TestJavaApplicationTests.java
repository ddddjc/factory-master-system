package com.djc;

import com.djc.entity.Vo.AccessoriesArrivalDetailVo;
import com.djc.entity.Vo.AccessoriesArrivalVo;
import com.djc.mapper.AccessoriesArrivalDetailMapper;
import com.djc.mapper.AccessoriesArrivalMapper;
import org.junit.jupiter.api.Test;
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
    @Test
    public void a(){
        AccessoriesArrivalDetailVo accessoriesArrivalDetailVo = accessoriesArrivalDetailMapper.queryVoById(1);
        System.out.println(accessoriesArrivalDetailVo);
    }
    @Autowired
    AccessoriesArrivalMapper accessoriesArrivalMapper;
    @Test
    public void b(){
        AccessoriesArrivalVo accessoriesArrivalVo = accessoriesArrivalMapper.queryVoById(1);
        System.out.println(accessoriesArrivalVo);
    }
}
