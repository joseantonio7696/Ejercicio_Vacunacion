package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import dao.VacunaDao;
import excepciones.CodVacunacionException;
import modelo.Vacunacion;

public class VacunaController {
	
	Connection cn;

	public VacunaController(Connection cn) {
		this.cn=cn;
	}

	public List<Vacunacion> getConsulta() throws SQLException {
		
		List<Vacunacion>listadoVacunaciones;
		
		VacunaDao vacuna=new VacunaDao(cn);
		
		String sql="select * from vacunacion";
		
		listadoVacunaciones=vacuna.getConsulta(sql);
		
		return listadoVacunaciones;
	}

	public boolean agregarVacuna(String codVacunacion, String paciente, String tipoVacuna, String fechaNacimiento, String primeraDosis, String segundaDosis, String vacunado) throws CodVacunacionException, ParseException, SQLException {
		
		boolean agregado=false;
		
		Vacunacion vacuna =new Vacunacion(codVacunacion, paciente, tipoVacuna, fechaNacimiento, primeraDosis, segundaDosis, vacunado);
		VacunaDao agregarVacuna=new VacunaDao(cn);
		String sql="insert into vacunacion values (?,?,?,?,?,?,?,?)";
		agregado=agregarVacuna.agregarVacuna(sql,vacuna);
		
		
		return agregado;
	}

}
