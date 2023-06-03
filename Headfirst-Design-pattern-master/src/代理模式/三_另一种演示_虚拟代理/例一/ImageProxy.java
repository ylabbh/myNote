package 代理模式.三_另一种演示_虚拟代理.例一;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class ImageProxy implements Icon {

	//这里的imageIcon是我们真正希望得到的。
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
     
	public ImageProxy(URL url) { imageURL = url; }
	/*------------如果还没有图片，就先加载默认狂傲*/
	public int getIconWidth() {
		if (imageIcon != null) {
            return imageIcon.getIconWidth();
        } else {
			return 800;
		}
	}
	public int getIconHeight() {
		if (imageIcon != null) {
            return imageIcon.getIconHeight();
        } else {
			return 600;
		}
	}

	/**
	 * 注意这里，虚拟代理最关键的地方就在于。
	 * @param c
	 * @param g
	 * @param x
	 * @param y
	 */
	public void paintIcon(final Component c, Graphics  g, int x, int y) {
		if (imageIcon != null) {
			imageIcon.paintIcon(c, g, x, y);
		} else {
			/**
			 * 如果被代理对象还未准备就绪，或第一次访问，为空的时候，那么我就先执行代理方法，否则执行原对象。
			 */
			g.drawString("Loading CD cover, please wait...", x+300, y+190);
			if (!retrieving) {
				retrieving = true;
				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
							//在imageIcon被创建之后，下次调用到paintIcon()时，直接委托imageIcon进行
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}
}