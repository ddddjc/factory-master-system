package com.djc;

import com.djc.mapper.MaintenanceArrangeMapper;
import com.djc.mapper.MaintenanceEmployeeMapper;
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
    MaintenanceEmployeeMapper maintenanceEmployeeMapper;
    @Autowired
    MaintenanceArrangeMapper maintenanceArrangeMapper;
    @Test
    public void a(){
        System.out.println(maintenanceEmployeeMapper.queryMaintenanceEmployeeVo(1).toString());
        System.out.println(1);
    }
    @Test
    public void b(){
        System.out.println(maintenanceArrangeMapper.queryVoById(1).toString());
    }
}
