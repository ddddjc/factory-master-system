package com.djc;

import com.djc.entity.Vo.AccessoriesProcurementDetialVo;
import com.djc.entity.Vo.AccessoriesProcurementVo;
import com.djc.mapper.AccessoriesProcurementDetailMapper;
import com.djc.mapper.AccessoriesProcurementMapper;
import com.djc.mapper.MaintenanceArrangeMapper;
import com.djc.mapper.MaintenanceEmployeeMapper;
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
    MaintenanceEmployeeMapper maintenanceEmployeeMapper;
    @Autowired
    MaintenanceArrangeMapper maintenanceArrangeMapper;
    @Autowired
    AccessoriesProcurementDetailMapper accessoriesProcurementDetailMapper;
    @Test
    public void a(){
        System.out.println(maintenanceEmployeeMapper.queryMaintenanceEmployeeVo(1).toString());
        System.out.println(1);
    }
    @Test
    public void b(){
        System.out.println(maintenanceArrangeMapper.queryVoById(1).toString());
    }

    @Test
    public void c(){
        List<AccessoriesProcurementDetialVo> accessoriesProcurementDetialVos = accessoriesProcurementDetailMapper.queryDetailVo(1);
        for (AccessoriesProcurementDetialVo a:accessoriesProcurementDetialVos
             ) {
            System.out.println(a);
        }
    }
    @Autowired
    AccessoriesProcurementMapper accessoriesProcurementMapper;
    @Test
    public void d(){
        AccessoriesProcurementVo accessoriesProcurementVo = accessoriesProcurementMapper.queryVoById(1);
        System.out.println(accessoriesProcurementVo);
    }
}
