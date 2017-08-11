package co.jp.higuschool.employee;

public class CompanyFactory {

	public AbstractCompany createCompany(String sectionCode) {

		if (sectionCode.equals("1")) {
			return new Jinjibu();

		} else if (sectionCode.equals("2")) {
			return new Soumubu();

		} else if (sectionCode.equals("3")) {
			return new Systembu();

		} else {
			return new Sonota();
		}
	}

}
