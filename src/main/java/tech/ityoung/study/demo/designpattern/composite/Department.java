package tech.ityoung.study.demo.designpattern.composite;

import lombok.Data;

@Data
public class Department extends OrganizationComponent {
    public Department(String name, String description) {
        super(name, description);
    }

    @Override
    public void print() {
        System.out.println(this.getName() + " : " + this.getDescription());
    }


}
