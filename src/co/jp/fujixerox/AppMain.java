package co.jp.fujixerox;

import java.util.List;
import java.util.ResourceBundle;

import co.jp.fujixerox.employee.AbstractCompany;
import co.jp.fujixerox.employee.CompanyFactory;
import co.jp.fujixerox.employee.EmpEntity;
import co.jp.fujixerox.employee.Employee;
/**
 * csvの内容を表示する
 *
 * @author haruka
 *
 */
public class AppMain {
	public static void main(String[] args) throws Throwable {
		String filePath_key = "FilePath";
		String fileName_key = "FileName";

		ResourceBundle rb = ResourceBundle.getBundle("lesson");
		String filePath = rb.getString(filePath_key);
		String fileName = rb.getString(fileName_key);
		String fileFullPath = filePath + fileName;

		Employee employee = new Employee();
		List<EmpEntity> employeeData = employee.employeeInfo(fileFullPath);

		try {
			for(EmpEntity showData : employeeData) {
				CompanyFactory factory = new CompanyFactory();
				AbstractCompany abstractCo = factory.createCompany(showData.getSectionCode());
				System.out.println("社員番号:" + showData.getEmpNumber() + " 社員名:" + showData.getEmpName());
				abstractCo.sectionInfo();
				abstractCo.showInfo();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
