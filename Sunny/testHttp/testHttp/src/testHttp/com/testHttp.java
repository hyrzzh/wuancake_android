package testHttp.com;

public class testHttp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HttpRequest demo = new HttpRequest();
//		final String url = "http://mobile.weather.com.cn/data/sk/101010100.html?_=1381891661455";
		final String url = "http://mobile.weather.com.cn/data/sk/101010100.html";
		final String param = "_=1381891661455";
		System.out.println(HttpRequest.sendGet(url, param));
		System.out.println("end");
	}

}
