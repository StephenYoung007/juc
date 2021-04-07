package tech.ityoung.study.demo.designpattern.composite;

import lombok.Data;

import java.util.List;

@Data
public class College extends MainComponent {
    public College(String name, String description) {
        super(name, description);
    }
}
