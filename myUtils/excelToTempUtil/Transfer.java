package myUtils.excelToTempUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Transfer {
	
	public static void main(String[] args) {
		transfer();
	}
	
	public static void transfer() {
		Transfer t = new Transfer();
		Map<String, List<Map<String,String>>> dataModel = t.readExcel("D:\\MyWorkplace\\myUtils\\src\\main\\java\\myUtils\\test.xlsx");
		Configuration cfg = t.getCfg("D:\\MyWorkplace\\myUtils\\src\\main\\java\\myUtils\\");
		try {
			Template temp = cfg.getTemplate("test.xml");
			temp.process(dataModel, new OutputStreamWriter(new FileOutputStream("D:\\MyWorkplace\\myUtils\\src\\main\\java\\myUtils\\test.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ����excel�ļ�
	 */
	public Map<String, List<Map<String,String>>> readExcel(String path) {
		Map<String, List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();
		List<Map<String,String>> contents = new ArrayList<Map<String,String>>();
		
		
		try {
			InputStream in = new FileInputStream(new File(path));
			// ��ȡ������
			XSSFWorkbook workBook = new XSSFWorkbook(in);
			// ��ȡ���
			XSSFSheet sheet = workBook.getSheetAt(0);
			// ��ȡ������Ϊ����
			XSSFRow row = sheet.getRow(0);
			// �����
			// �ȱ���ÿһ��
			for (int i=1; i<sheet.getLastRowNum(); i++) {
				Map<String,String> content =  new HashMap<String,String>();
				// �ٱ���ÿһ��
				if (sheet.getRow(i) == null) {
					continue;
				}
				for (int j=0; j<row.getLastCellNum(); j++) {
					// ������Ϊkey����
					String title = row.getCell(j).toString();
					// ������Ϊvalue����
					String msg;
					if (sheet.getRow(i).getCell(j) ==null) {
						msg = "";
					}else {
						msg = sheet.getRow(i).getCell(j).toString();
					}
					content.put(title, msg);
				}
				// ÿ�α��������list��
				contents.add(content);
			}
			map.put("text", contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * ���ģ������
	 * @author GarfieldHan
	 * @date 2018��11��24��
	 * @param path �ļ���Ŀ¼ 
	 * @return
	 */
	public Configuration getCfg(String path) {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		try {
			cfg.setDirectoryForTemplateLoading(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		return cfg;
	}
}
