package tech.ityoung.study.demo.jvm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class StackOverFlow01 {
    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setDeptName("dev");

        Emp emp1 = new Emp();
        emp1.setName("张三");
        emp1.setDept(dept);

        Emp emp2 = new Emp();
        emp2.setName("张三");
        emp2.setDept(dept);

        dept.setEmployees(Arrays.asList(emp1, emp2));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(dept);
    }
}

@Data
class Dept {
    private String deptName;
    @JsonIgnore
    private List<Emp> employees;
}

@Data
class Emp {
    private String name;
    private Dept dept;
}
