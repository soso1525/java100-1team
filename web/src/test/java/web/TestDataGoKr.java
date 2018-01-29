package web;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class TestDataGoKr {

	public static void main(String[] args) throws IOException {

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=AMW5V6IKzRS6bslVChrsfXWson6%2FgDspQvrV9%2F5ZgGr97gzyr43o8FtxbNHArOiLznJqPKavjjSMNIVs0lzLYA%3D%3D"); /* Service Key */
		/*
		urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_dg_cd", "UTF-8") + "="
				+ URLEncoder.encode("41", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_cd", "UTF-8") + "="
				+ URLEncoder.encode("117", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("ldong_addr_mgpl_sggu_emd_cd", "UTF-8") + "="
				+ URLEncoder.encode("101", "UTF-8"));
		*/
		
		urlBuilder.append(
				"&" + URLEncoder.encode("wkpl_nm", "UTF-8") + "=" + URLEncoder.encode("삼성전자", "UTF-8")); /* 사업장명 */
		urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no", "UTF-8") + "="
				+ URLEncoder.encode("1248150", "UTF-8")); /* 사업자등록번호(앞에서 6자리) */
		/*
		urlBuilder.append(
				"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
		urlBuilder.append(
				"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
		*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append( line );
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}
