package 模板方法模式.一个叫钩子的方法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("咖啡泡一会....");
    }

    @Override
    void addCondiments() {
        System.out.println("加入牛奶....");
    }


    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")){
            return true;
        }else{
            return false;
        }
    }

    public String getUserInput(){
        String answer = null;

        System.out.println("是否要往咖啡中加点牛奶？(y/n)");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null){
            return "n";
        }
        return answer;

    }
}
