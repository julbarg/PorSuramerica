package test;

public class Test {

	public static void main(String[] args) {
		String url = "http://localhost:8080/PorSuramerica/pages/admin.jsf";
		int index = url.indexOf("/PorSuramerica/")+ "/PorSuramerica/".length();
		url = url.substring(0, index);
		System.out.println(url);
	}

}
