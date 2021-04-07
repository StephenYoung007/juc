package tech.ityoung.study.demo.designpattern.composite;

public class Client {
    public static void main(String[] args) {
        University university = new University("清华大学", "中国顶尖大学");
        College mechanical = new College("机械工程学院", "工资不高的学院");
        mechanical.add(new Department("mechanical engineer", "no wife"));
        mechanical.add(new Department("mechanical manufacture", "no money"));
        College chemistry = new College("化学工程学院", "有可能中毒的学院");
        chemistry.add(new Department("chemistry engineer", "no money"));
        chemistry.add(new Department("Chemical Engineering and Technology", "no money"));
        university.add(mechanical);
        university.add(chemistry);
        university.print();
    }
}
