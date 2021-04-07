package tech.ityoung.study.demo.designpattern.composite;

import lombok.Data;

import java.util.List;

@Data
public class University extends MainComponent {
    public University(String name, String description) {
        super(name, description);
    }
}
