package com.fernandoluiz.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Responsável por conter os métodos para decodificar parâmetro de URL
 * 
 * @author Fernando
 *
 */

public class URL {

	/**
	 * Responsável por receber os parametros do tipo string e decodificar;
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
	/**
	 * Responsável por receber os parametros do tipo Date e decodificar;
	 * @param textDate
	 * @param defaultValue - Em caso de problemas de conversao da Data, sera atribuido um valor de data padrao 
	 * @return
	 */
	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
}
