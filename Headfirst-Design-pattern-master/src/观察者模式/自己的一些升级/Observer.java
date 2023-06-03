package 观察者模式.自己的一些升级;

public interface Observer {

    void update(String message,String subjectName);//接收消息，既然消息源是统一的，那么入参也一定是一致的

    public void removeSubject(Subject subject);

}
