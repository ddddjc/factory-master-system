package com.example;

import com.djc.mapper.MaintenanceArrangeMapper;
import com.djc.mapper.MaintenanceEmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class TestJavaApplicationTests {
    public static void main(String[] args) {
    }

    @Autowired
    MaintenanceEmployeeMapper maintenanceEmployeeMapper;
    @Autowired
    MaintenanceArrangeMapper maintenanceArrangeMapper;
    @Test
    public void a(){
        maintenanceEmployeeMapper.queryMaintenanceEmployeeVo(1);
    }
    @Test
    public void b(){
        System.out.println(maintenanceArrangeMapper.queryVoById(1));
    }
}
