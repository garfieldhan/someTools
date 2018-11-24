package myUtils.excelToTempUtil;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import myUtils.AbstractFrame;

public class ExcelToTemFrame extends AbstractFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Container con = new Container();//
	private JLabel label1 = new JLabel("选择导入的EXCEL文件");
	private JLabel label2 = new JLabel("选择导入的模板文件");
	private JLabel label3 = new JLabel("选择导出的文件路径");
	private JTextField text1 = new JTextField();// TextField 目录的路径
	private JTextField text2 = new JTextField();// 文件的路径
	private JTextField text3 = new JTextField();// 文件的路径
	private JButton button1 = new JButton("选择");// 选择
	private JButton button2 = new JButton("选择");// 选择
	private JButton button3 = new JButton("选择");// 选择
	private JButton button4 = new JButton("确定");//
	private JFileChooser jfc = new JFileChooser();// 文件选择器
	
	public ExcelToTemFrame() {
		super();
		setBounds(super.getLocation().x-100, super.getLocation().y+100, 600, 200);
		label1.setBounds(10, 10, 140, 20);
		label2.setBounds(10, 35, 140, 20);
		label3.setBounds(10, 60, 140, 20);
		text1.setBounds(155, 10, 350, 20);
		text2.setBounds(155, 35, 350, 20);
		text3.setBounds(155, 60, 350, 20);
		text1.setEditable(false);
		text2.setEditable(false);
		text3.setEditable(false);
		button1.setBounds(510, 10, 60, 20);
		button2.setBounds(510, 35, 60, 20);
		button3.setBounds(510, 60, 60, 20);
		button4.setBounds(250, 85, 60, 20);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		jfc.setApproveButtonText("确定");	//设定按钮名字
		con.add(label1);
		con.add(label2);
		con.add(label3);
		con.add(text1);
		con.add(text2);
		con.add(text3);
		con.add(button1);
		con.add(button2);
		con.add(button3);
		con.add(button4);
		this.add(con);
	}
	
	/**
	 * 事件监听
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);// 设定只能选择到文件
			// 设定只能选EXCEL文件
			jfc.addChoosableFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return "*.xls;*.xlsx";
				}
				@Override
				public boolean accept(File f) {
					String name = f.getName();  
			        return f.isDirectory() || name.toLowerCase().endsWith(".xls") || name.toLowerCase().endsWith(".xlsx");  // 仅显示目录和xls、xlsx文件
				}
			});
			selectFile(text1);
		}
		if (e.getSource().equals(button2)) {
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);// 设定只能选择到文件
			selectFile(text2);
		}
		if (e.getSource().equals(button3)) {
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 设定只能选择到文件夹
			selectFile(text3);
		}
		if (e.getSource().equals(button4)) {
			// 弹出对话框
			// JOptionPane.showMessageDialog(null, "弹出对话框的实例，欢迎您-漆艾琳！", "提示", 2);
			Transfer.transfer();
		}
	}
	
	/**
	 * JFileChooser的封装
	 */
	public void selectFile(JTextField text) {
		int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
		if (state == 1) {
			return;
		} else {
			File f = jfc.getSelectedFile();// f为选择到的目录
			text.setText(f.getAbsolutePath());
		}
	}
}


