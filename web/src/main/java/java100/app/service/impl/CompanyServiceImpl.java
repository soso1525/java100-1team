package java100.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import java100.app.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Override
	public boolean isMatchCompanyInfo ( String companyName, String companyNumber ) {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B552015/NpsBplcInfoInqireService/getBassInfoSearch"); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=AMW5V6IKzRS6bslVChrsfXWson6%2FgDspQvrV9%2F5ZgGr97gzyr43o8FtxbNHArOiLznJqPKavjjSMNIVs0lzLYA%3D%3D");
			urlBuilder.append(
					"&" + URLEncoder.encode("wkpl_nm", "UTF-8") + "=" + URLEncoder.encode(companyName, "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("bzowr_rgst_no", "UTF-8") + "="
					+ URLEncoder.encode(companyNumber, "UTF-8"));
			
			String urls = urlBuilder.toString();
			System.out.println(urls);
			
			URL url = new URL(urls);
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
			
			StringBuilder resXml = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				resXml.append( line );
			}
			
			int p0 = resXml.indexOf("<totalCount>");
			if ( p0 < 0 ) {
				throw new RuntimeException("<totalCount> ����!");
			}
			p0 += "<totalCount>".length();
			
			int p1 = resXml.indexOf("</totalCount>");
			if ( p1 < 0 ) {
				throw new RuntimeException("</totalCount> ����!");
			}
			// p1 += "</totalCount>".length();
			
			String s = resXml.substring(p0, p1);
			int cnt = Integer.parseInt(s); // 0 ~ xxx
			
			
			rd.close();
			conn.disconnect();
			
			//return true;
			if(cnt > 0)
				return true;
			else return false;
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		
	}
}
