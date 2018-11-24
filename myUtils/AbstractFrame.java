package myUtils;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public AbstractFrame() {
		// 设置居中显示
		double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation(new Point((int) (lx / 2 - 200), (int) (ly / 2 -100)));// 设定窗口出现位置
		// 设置显示
		setVisible(true);
		// 设置大小
		setSize(300, 200);
	}
}
