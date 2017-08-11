package co.jp.fujixerox.employee;

public abstract class AbstractCompany {

	abstract public void sectionInfo();

	public void introduce() {
		System.out.println("社員の紹介です。");
	}

	abstract public void showInfo();

}
