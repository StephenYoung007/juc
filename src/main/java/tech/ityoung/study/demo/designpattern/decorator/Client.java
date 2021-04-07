package tech.ityoung.study.demo.designpattern.decorator;

public class Client {
    public static void main(String[] args) {
        Drink drink = new Coffee();
        Drink sugar = new Sugar(drink);
        Drink salt = new Salt(sugar);
        Drink sugar1 = new Sugar(salt);
        Drink salt1 = new Salt(sugar1);
        System.out.println(salt1.print());
        System.out.println("the total price is " + salt1.cost());
    }
}
