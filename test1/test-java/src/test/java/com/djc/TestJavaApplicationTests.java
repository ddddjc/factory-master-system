package com.djc;

import com.djc.entity.AccessoriesInboundDetail;
import com.djc.entity.Vo.AccessoriesArrivalVo;
import com.djc.entity.Vo.AccessoriesInboundVo;
import com.djc.entity.Vo.AccessoriesOutboundDetailVo;
import com.djc.entity.Vo.AccessoriesOutboundVo;
import com.djc.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    AccessoriesOutboundDetailMapper accessoriesOutboundDetailMapper;

    @Autowired
    AccessoriesOutboundMapper accessoriesOutboundMapper;
    @Test
    public void test(){
        AccessoriesOutboundVo accessoriesOutboundVo = accessoriesOutboundMapper.queryVoById(1);
        System.out.println(accessoriesOutboundVo);
    }
    @Autowired
    AccessoriesArrivalMapper accessoriesArrivalMapper;
    @Test
    public void test1(){
        AccessoriesArrivalVo accessoriesArrivalVo = accessoriesArrivalMapper.queryVoById(1);
        System.out.println(accessoriesArrivalVo);
    }

    @Test
    public void test2(){
        List<AccessoriesOutboundDetailVo> accessoriesOutboundDetailVos = accessoriesOutboundDetailMapper.queryVoById(1);
        System.out.println(accessoriesOutboundDetailVos);
    }
    @Autowired
    AccessoriesInboundDetailMapper accessoriesInboundDetailMapper;
    @Test
    public void test3(){
        List<AccessoriesInboundDetail> accessoriesInboundDetails = accessoriesInboundDetailMapper.queryVoByInboundId(1);
        System.out.println(accessoriesInboundDetails);
    }
    @Autowired
    AccessoriesInboundMapper accessoriesInboundMapper;
    @Test
    public void test4(){
        AccessoriesInboundVo accessoriesInboundVo = accessoriesInboundMapper.queryVoById(1);
        System.out.println(accessoriesInboundVo);
    }
}
