import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class 定时任务 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(),10000,1000);
    }
}

class MyTimerTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("现在时间" + System.currentTimeMillis());
        System.out.println("起床背单词");
    }
}