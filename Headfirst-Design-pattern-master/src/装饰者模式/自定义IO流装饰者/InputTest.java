package 装饰者模式.自定义IO流装饰者;

import java.io.*;

public class InputTest {

    //读取test.txt后，转小写输出到控制台
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\work\\myHNcode\\02_源码\\01_源码\\设计模式\\src\\装饰者模式\\自定义IO流装饰者\\test.txt")));
            while ((c = in.read()) >= 0){
                System.out.print((char)c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
