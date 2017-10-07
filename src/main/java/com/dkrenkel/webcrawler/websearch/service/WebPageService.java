/**
 * 
 */
package com.dkrenkel.webcrawler.websearch.service;

import java.io.IOException;
import java.util.List;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface WebPageService {

	List<String> getJsLibraries(String url) throws IOException;
}
