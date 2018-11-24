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
	private JLabel label1 = new JLabel("ѡ�����EXCEL�ļ�");
	private JLabel label2 = new JLabel("ѡ�����ģ���ļ�");
	private JLabel label3 = new JLabel("ѡ�񵼳����ļ�·��");
	private JTextField text1 = new JTextField();// TextField Ŀ¼��·��
	private JTextField text2 = new JTextField();// �ļ���·��
	private JTextField text3 = new JTextField();// �ļ���·��
	private JButton button1 = new JButton("ѡ��");// ѡ��
	private JButton button2 = new JButton("ѡ��");// ѡ��
	private JButton button3 = new JButton("ѡ��");// ѡ��
	private JButton button4 = new JButton("ȷ��");//
	private JFileChooser jfc = new JFileChooser();// �ļ�ѡ����
	
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
		jfc.setApproveButtonText("ȷ��");	//�趨��ť����
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
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {// �жϴ��������İ�ť���ĸ�
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);// �趨ֻ��ѡ���ļ�
			// �趨ֻ��ѡEXCEL�ļ�
			jfc.addChoosableFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return "*.xls;*.xlsx";
				}
				@Override
				public boolean accept(File f) {
					String name = f.getName();  
			        return f.isDirectory() || name.toLowerCase().endsWith(".xls") || name.toLowerCase().endsWith(".xlsx");  // ����ʾĿ¼��xls��xlsx�ļ�
				}
			});
			selectFile(text1);
		}
		if (e.getSource().equals(button2)) {
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);// �趨ֻ��ѡ���ļ�
			selectFile(text2);
		}
		if (e.getSource().equals(button3)) {
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// �趨ֻ��ѡ���ļ���
			selectFile(text3);
		}
		if (e.getSource().equals(button4)) {
			// �����Ի���
			// JOptionPane.showMessageDialog(null, "�����Ի����ʵ������ӭ��-�ᰬ�գ�", "��ʾ", 2);
			Transfer.transfer();
		}
	}
	
	/**
	 * JFileChooser�ķ�װ
	 */
	public void selectFile(JTextField text) {
		int state = jfc.showOpenDialog(null);// �˾��Ǵ��ļ�ѡ��������Ĵ������
		if (state == 1) {
			return;
		} else {
			File f = jfc.getSelectedFile();// fΪѡ�񵽵�Ŀ¼
			text.setText(f.getAbsolutePath());
		}
	}
}


