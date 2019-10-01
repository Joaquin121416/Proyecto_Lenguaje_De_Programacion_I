package com.starbucks.sistema.venta.logica.Patrones;

import java.util.regex.*;

public class Patrones {
	public int ValidarCodEmp(String codEmp) {

		Pattern patron = Pattern.compile("[A-Z]{1}+[0-9]{4}");
		Matcher encaja = patron.matcher(codEmp);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarNomGen(String nombre) {

		Pattern patron = Pattern.compile("[a-zA-Z0-9 ]{5,100}");
		Matcher encaja = patron.matcher(nombre);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarNombrePersona(String nombre) {

		Pattern patron = Pattern.compile("[a-zA-Z ]{5,100}");
		Matcher encaja = patron.matcher(nombre);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarCodigoCat(String codigo) {

		Pattern patron = Pattern.compile("[A-Z]{1}+[0-9]{12}");
		Matcher encaja = patron.matcher(codigo);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}

	}

	public int ValidarDescripcion(String descripcion) {

		Pattern patron = Pattern.compile("[a-zA-Z0-9 ]{5,500}");
		Matcher encaja = patron.matcher(descripcion);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarPrecios(String precio) {

		Pattern patron = Pattern.compile("[a-zA-Z0-9 ]{5,500}");
		Matcher encaja = patron.matcher(precio);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarDni(String dni) {

		Pattern patron = Pattern.compile("[0-9]{8}");
		Matcher encaja = patron.matcher(dni);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

	public int ValidarNumDoc(String dni) {

		Pattern patron = Pattern.compile("[0-9]{8,13}");
		Matcher encaja = patron.matcher(dni);
		if (encaja.matches()) {
			return 1;
		}

		else {

			return 0;
		}
	}

}
