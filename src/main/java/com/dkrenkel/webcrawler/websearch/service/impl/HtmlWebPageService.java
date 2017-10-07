/**
 * 
 */
package com.dkrenkel.webcrawler.websearch.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dkrenkel.webcrawler.util.WebPageAccessUtil;
import com.dkrenkel.webcrawler.websearch.service.WebPageService;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class HtmlWebPageService implements WebPageService {
	
	private static final String REGEX_JS = "([a-z])+.js";

	public List<String> getJsLibraries(String url) throws IOException {
		String htmlPage = WebPageAccessUtil.getHtmlPage(url);
		List<String> libraries = new ArrayList<String>();
		Pattern p = Pattern.compile(REGEX_JS);
		Matcher matcher = p.matcher(htmlPage);
		while (matcher.find()) {
			libraries.add(matcher.group());
		}
		return libraries;
	}

}
