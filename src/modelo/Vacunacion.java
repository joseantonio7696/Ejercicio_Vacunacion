package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import excepciones.CodVacunacionException;

public class Vacunacion {

	private int idVacunacion;
	private String codVacunacion;
	private String paciente;
	private String tipoVacuna;
	private java.sql.Date fechaNacimiento;
	private java.sql.Date primeraDosis;
	private java.sql.Date segundaDosis;
	private boolean vacunado;

	public Vacunacion(String codVacunacion, String paciente, String tipoVacuna, String fechaNacimiento,
			String primeraDosis, String segundaDosis, String vacunado) throws CodVacunacionException, ParseException {
		super();
		this.idVacunacion = 0;
		this.setCodVacunacion(codVacunacion);
		this.setPaciente(paciente);
		this.setTipoVacuna(tipoVacuna);
		this.setFechaNacimiento(fechaNacimiento);
		this.setPrimeraDosis(primeraDosis);
		this.setSegundaDosis(segundaDosis);
		this.setVacunado(vacunado);
	}

	public Vacunacion(int idVacunacion, String codVacunacion, String paciente, String tipoVacuna, Date fechaNacimiento,
			Date primeraDosis, Date segundaDosis, boolean vacunado) {
		super();
		this.idVacunacion = idVacunacion;
		this.codVacunacion = codVacunacion;
		this.paciente = paciente;
		this.tipoVacuna = tipoVacuna;
		this.fechaNacimiento = fechaNacimiento;
		this.primeraDosis = primeraDosis;
		this.segundaDosis = segundaDosis;
		this.vacunado = vacunado;
	}

	public int getIdVacunacion() {
		return idVacunacion;
	}

	public void setIdVacunacion(int idVacunacion) {
		this.idVacunacion = idVacunacion;
	}

	public String getCodVacunacion() {
		return codVacunacion;
	}

	public void setCodVacunacion(String codVacunacion) throws CodVacunacionException {

		if (codVacunacion.length() != 20) {
			throw new CodVacunacionException();
		} else {

			String numEntidadSucursal = codVacunacion.substring(0, 8);
			numEntidadSucursal = "00" + numEntidadSucursal;
			String digitoD = Character.toString(codVacunacion.charAt(8));
			String digitoC = Character.toString(codVacunacion.charAt(9));
			String numCuentaBancaria = codVacunacion.substring(10, 20);

			int[] numeros = { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };

			int acuEntidadSucursal = 0;
			int acuNumCuenta = 0;

			for (int x = 0; x < numeros.length; x++) {

				acuEntidadSucursal += Integer.parseInt(Character.toString(numEntidadSucursal.charAt(x))) * numeros[x];
				acuNumCuenta += Integer.parseInt(Character.toString(numCuentaBancaria.charAt(x))) * numeros[x];

			}

			int D = 11 - (acuEntidadSucursal % 11);
			int C = 11 - (acuNumCuenta % 11);

			if (D == 10) {
				D = 1;
			}
			if (D == 11) {
				D = 0;
			}

			if (C == 10) {
				C = 1;
			}
			if (C == 11) {
				C = 0;
			}

			if ((D == Integer.parseInt(digitoD)) && (C == Integer.parseInt(digitoC))) {

				this.codVacunacion = codVacunacion;

			} else {
				throw new CodVacunacionException();
			}
		}

	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(String tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public java.sql.Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) throws ParseException {
		
		java.util.Date fechaUtil;
		
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		
		fechaUtil=formateador.parse(fechaNacimiento);
		
		this.fechaNacimiento = new java.sql.Date(fechaUtil.getTime());
	}

	public java.sql.Date getPrimeraDosis() {
		return primeraDosis;
	}

	public void setPrimeraDosis(String primeraDosis) throws ParseException {
		
		java.util.Date fechaUtil;
		
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		
		fechaUtil=formateador.parse(primeraDosis);
		
		this.primeraDosis = new java.sql.Date(fechaUtil.getTime());
	}

	public java.sql.Date getSegundaDosis() {
		return segundaDosis;
	}

	public void setSegundaDosis(String segundaDosis) throws ParseException {
		
		java.util.Date fechaUtil;
		
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		
		fechaUtil=formateador.parse(segundaDosis);
		
		this.segundaDosis = new java.sql.Date(fechaUtil.getTime());
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(String vacunado) {
		
		this.vacunado = Boolean.parseBoolean(vacunado);
	}

	@Override
	public String toString() {
		return idVacunacion + "," + codVacunacion + "," + paciente + "," + tipoVacuna + "," + fechaNacimiento + ","
				+ primeraDosis + "," + segundaDosis + "," + vacunado;
	}

}
