package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public class Tea extends Drink{
    public Tea() {
        super("茶", "Tea", 15);
    }

    @Override
    public int cost() {
        return 20;
    }

    @Override
    public String print() {
        return "this is a cup of Tea ";
    }
}
