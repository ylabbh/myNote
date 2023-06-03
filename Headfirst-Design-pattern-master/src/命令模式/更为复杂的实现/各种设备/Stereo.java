package 命令模式.更为复杂的实现.各种设备;

/**
 * 音响设备，可以打开、播放CD模式，设置音量
 */
public class Stereo {

    Integer volume;

    String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("Stereo(name:"+name+") 音响打开了！");
    }

    public void off(){
        System.out.println("Stereo(name:"+name+") 音响关闭了！");
    }

    public void setCD(){
        System.out.println("Stereo(name:"+name+") 音响调成CD模式！");
    }

    public void setVolume(Integer volume) {
        if (volume != null && volume >= 0){
            this.volume = volume;
            System.out.println("Stereo(name:"+name+") 调整音量，当前音量：" + volume);
        }

    }
}
