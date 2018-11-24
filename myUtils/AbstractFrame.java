package myUtils;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public AbstractFrame() {
		// ���þ�����ʾ
		double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation(new Point((int) (lx / 2 - 200), (int) (ly / 2 -100)));// �趨���ڳ���λ��
		// ������ʾ
		setVisible(true);
		// ���ô�С
		setSize(300, 200);
	}
}
