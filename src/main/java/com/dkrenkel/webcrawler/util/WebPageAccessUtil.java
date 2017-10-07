/**
 * 
 */
package com.dkrenkel.webcrawler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class WebPageAccessUtil {
	
	public static String getHtmlPage(String url) throws IOException {
		URL oracle = new URL(url);
		System.setProperty("http.agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        String html = "";
		while ((inputLine = in.readLine()) != null) {
			html += inputLine + "\n";
		}
        in.close();		
		return html;
	}
}
