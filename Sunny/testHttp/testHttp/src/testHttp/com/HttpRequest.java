package testHttp.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequest {

	static String sendGet(String url, String param) {

		StringBuilder response = new StringBuilder();
		BufferedReader br = null;

		url = url + "?" + param;
		URL realurl;
		try {
			realurl = new URL(url);
			HttpURLConnection cn = (HttpURLConnection) realurl.openConnection();

			cn.setRequestMethod("GET");
			cn.setConnectTimeout(6 * 1000);
			cn.setReadTimeout(6 * 1000);
			cn.setRequestProperty("contentType", "UTF-8");

			if (cn.getResponseCode() != 200) {
				System.out.println("conn error!");
			}

			// InputStream is = cn.getInputStream();
			// BufferedReader br = new BufferedReader(new InputStreamReader(is,
			// "UTF-8"));
			br = new BufferedReader(new InputStreamReader(cn.getInputStream(), "UTF-8"));

			String line = "";
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("input url format error!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("send get request error!");
			e.printStackTrace();
		}

		finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return response.toString();
	}

}