package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public class Salt extends Dessert {
    public Salt(Drink drink) {
        super("盐巴", ",加一份盐", 2, drink);
    }

    public Salt() {
    }

    @Override
    public int cost() {
        return this.getDrink().cost() + getPrice();
    }
}
