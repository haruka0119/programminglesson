package co.jp.fujixerox.employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Employee {

	public Employee(){
	}

	public List<EmpEntity> employeeInfo(String filePath) throws Throwable {
		File fileName = null;
		FileInputStream input = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		List<EmpEntity> empEntityList = new ArrayList<EmpEntity>();

		try {
			fileName = new File(filePath);
			input = new FileInputStream(fileName);
			reader = new InputStreamReader(input,"SJIS");
			br = new BufferedReader(reader);
			CSVParser parse = CSVFormat.EXCEL.parse(br);
			List<CSVRecord> recordList = parse.getRecords();

            for (CSVRecord record : recordList) {
            	int i = 0;
            	EmpEntity entity = new EmpEntity();
            	entity.setEmpNumber(record.get(i));
            	entity.setEmpName(record.get(++i));
            	entity.setSectionCode(record.get(++i));
            	empEntityList.add(entity);
            }

		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				br.close();
				reader.close();
				input.close();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		return empEntityList;
	}

}
