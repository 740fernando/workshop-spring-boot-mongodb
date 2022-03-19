package com.fernandoluiz.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class URL {

	/**
	 * Responsável por receber os parametros da request e decodificar;
	 * @param text
	 * @return
	 */
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
