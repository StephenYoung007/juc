package tech.ityoung.study.demo.designpattern.composite;

import lombok.Data;

@Data
public abstract class OrganizationComponent {
    private String name;
    private String description;

    public OrganizationComponent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public OrganizationComponent() {
    }

    public abstract void print();

    protected void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException();
    }
}
