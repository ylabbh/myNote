package 装饰者模式.自定义IO流装饰者;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 了解了IO类库使用的是装饰者模式后，我们可以定义自己的装饰者
 * 将读取的文件中所有大写的字符转换成小写
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    //针对字节转小写
    public int read() throws IOException{
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));

    }

    public int read(byte[] b,int offset, int len) throws IOException{
        int result = super.read(b,offset,len);
        for (int i = offset; i < offset+result; i++){
            b[i] = (byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }

}
