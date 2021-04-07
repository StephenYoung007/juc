package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public class Coffee extends Drink {
    public Coffee() {
        super("咖啡", "咖啡", 10);
    }

    @Override
    public int cost() {
        return getPrice();
    }

    @Override
    public String print() {
        return "this is a cup of coffee ";
    }
}
