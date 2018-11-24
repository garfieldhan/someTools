package myUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myUtils.excelToTempUtil.ExcelToTemFrame;

public class MainFrame extends AbstractFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel panel = new JPanel();
	private JButton buttonA = getButtonA();

	public MainFrame() {
		super();
		panel.add(buttonA);
		add(panel);
		// 设置点击关闭退出
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton getButtonA() {
		if (buttonA == null) {
			buttonA = new JButton("Excel模板生成器");
		}
		buttonA.setBounds(10, 10, 100, 100);
		buttonA.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new ExcelToTemFrame();
			}
			
		});
		return buttonA;
	}
}
