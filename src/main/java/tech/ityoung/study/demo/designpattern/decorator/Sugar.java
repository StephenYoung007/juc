package tech.ityoung.study.demo.designpattern.decorator;

import lombok.Data;

@Data
public class Sugar extends Dessert {
    public Sugar(Drink drink) {
        super("糖", "加一份糖", 3, drink);
    }

    public Sugar() {
    }

    @Override
    public int cost() {
        return this.getDrink().cost() + getPrice();
    }
}
