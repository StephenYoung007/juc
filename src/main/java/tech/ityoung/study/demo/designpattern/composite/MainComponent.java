package tech.ityoung.study.demo.designpattern.composite;

import lombok.Data;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.ArrayList;
import java.util.List;

@Data
public class MainComponent extends OrganizationComponent {
    private List<OrganizationComponent> subOrganizations = new ArrayList<>();

    @Override
    public void print() {
        System.out.println(this.getName() + ":" + this.getDescription());
        for (OrganizationComponent subOrganization : subOrganizations) {
            System.out.print("....");
            subOrganization.print();
        }
    }

    public MainComponent() {
    }

    public MainComponent(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        this.subOrganizations.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        this.subOrganizations.add(organizationComponent);
    }
}
