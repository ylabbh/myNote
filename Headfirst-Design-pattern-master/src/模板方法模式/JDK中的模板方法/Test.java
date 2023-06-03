package 模板方法模式.JDK中的模板方法;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("d1",8),
                new Duck("d2",2),
                new Duck("d3",7),
                new Duck("d4",10),
                new Duck("d5",2)};
        System.out.println("------排序前：");
        display(ducks);
        System.out.println("*------排序后");
        Arrays.sort(ducks);
        display(ducks);

    }

    public static void display(Duck[] ducks){
        for (int i = 0; i < ducks.length; i++) {
            System.out.print(ducks[i].name+"("+ducks[i].weight+")"+",");
        }
    }

}
