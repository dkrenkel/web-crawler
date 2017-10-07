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
import com.dkrenkel.webcrawler.websearch.service.WebSearchService;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class GoogleSearchService implements WebSearchService {

	private static final String REGEX_URL = "http://[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
	
	private static final String REGEX_GOOGLE_LINK_RESULT = "<h3 class=\"r\"><a href=\"\\/url\\?q=http://[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

	private static final String GOOGLE_URL = "http://www.google.com.br/search?q=";

	public List<String> searchPagesForTerm(String searchTerm) throws IOException {
		String googleSearchUrl = GOOGLE_URL + searchTerm;
		String htmlPage = WebPageAccessUtil.getHtmlPage(googleSearchUrl);

		List<String> urls = new ArrayList<String>();
		Pattern patternGoogleResult = Pattern.compile(REGEX_GOOGLE_LINK_RESULT);
		Matcher matcherGoogleResult = patternGoogleResult.matcher(htmlPage);
		while (matcherGoogleResult.find()) {
			Pattern patternUrl = Pattern.compile(REGEX_URL);
			Matcher matcherUrl = patternUrl.matcher(matcherGoogleResult.group());
			if (matcherUrl.find()) {
				String url = matcherUrl.group().replace("&amp", "");
				urls.add(url);
			}
		}

		return urls;
	}

}
