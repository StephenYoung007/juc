package tech.ityoung.study.demo.jvm;

import java.util.ArrayList;

public class StackOverFlow02 {

        public static void main(String[] args) {
            ArrayList list = new ArrayList();
            while (true) {
                list.add(new StackOverFlow02());
            }
        }
}
