package 观察者模式.自己的一些升级;

import java.util.ArrayList;
import java.util.List;

public class Person implements Observer,DisplayElement{

    Integer count = 0;//用来记录消息收到的条数

    public String subjectName;//既然能够接受消息，那么就对应的有对应参数进行接受
    public String message;//既然能够接受消息，那么就对应的有对应参数进行接受

    public String name;//本人姓名

    public List<Subject> subjects = new ArrayList<>();//我认为每个人都应该能够知道自己订阅的东西

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(name + "收到来自：" + subjectName + "的消息：" + message);
    }

    @Override
    public void update(String message,String subjectName) {
        this.subjectName = subjectName;
        this.message = message;
        count++;
        display();
    }

    @Override
    public void removeSubject(Subject subject){
        if (subjects.indexOf(subject) >= 0){
            subject.removeObserver(this);
            subjects.remove(subject);
        }
    }

    public void registSubject(Subject subject){
        if (subjects.indexOf(subject) < 0 ){
            subject.registerObserver(this);
            subjects.add(subject);
        }
    }

}
