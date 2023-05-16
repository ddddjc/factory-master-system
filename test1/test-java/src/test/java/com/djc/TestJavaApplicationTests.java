package com.djc;

import com.djc.entity.Employee;
import com.djc.entity.Information;
import com.djc.service.EmployeeService;
import com.djc.util.InformationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-04-29-17:13
 * @Description:
 */
@SpringBootTest(classes = TestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestJavaApplicationTests {
    public static void main(String[] args) {
    }
    @Autowired
    InformationUtils informationUtils;

    @Autowired
    EmployeeService employeeService;
    @Test
    public void test1() throws ParseException {
        informationUtils.sendInformation(111,111,"title","content","pr");
    }
    @Test
    public void test3() throws ParseException {
        List<Employee> employees = employeeService.queryByRole("staff");
        informationUtils.sendInformation(112,employees,"title","content","priority");
    }
}
