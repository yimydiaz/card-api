package com.credibanco.assessment.card.util;

public class Util {

	public static String enmascararNumero(Long num) {
		String numIn = num + "";
		String numMask = "";
		char[] arr = numIn.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (i > 5 && i < (arr.length - 4)) {
				numMask += "*";
			} else
				numMask += arr[i];
		}
		return numMask;
	}

	public static Integer generarNumeroAzar() {
		return (int) (Math.random() * 100 + 1);
	}

	/**
	 * Metodo que valida si un string es numero
	 * 
	 * @param texto a validar
	 * 
	 * @return boolean
	 */
	public static boolean isNumeric(String texto) {
		if (texto == null) {
			return false;
		}
		try {
			Double.parseDouble(texto);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
