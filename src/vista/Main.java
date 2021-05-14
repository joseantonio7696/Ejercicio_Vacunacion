package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import controlador.VacunaController;
import dao.DbConnection;
import excepciones.CodVacunacionException;
import modelo.Vacunacion;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		String codVacunacion="50031585677737100444";
		String paciente="Jose Antonio";
		String tipoVacuna="pFizer";
		String fechaNacimiento="1996-06-07";
		String primeraDosis="1996-06-07";
		String segundaDosis="1996-06-07";
		String vacunado="true";
		
		/*
		try {
			Vacunacion vacuna=new Vacunacion(codVacunacion, paciente, tipoVacuna, fechaNacimiento, primeraDosis, segundaDosis, vacunado);
			System.out.println(vacuna);
			
			
			
		} catch (CodVacunacionException | ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		*/
		
		/*
		
		DbConnection dbc=new DbConnection();
		
		Connection cn=dbc.getConnection();
		
		VacunaController vacuna=new VacunaController(cn);
		
		List<Vacunacion>listadoVacunacion;
		
		try {
			listadoVacunacion=vacuna.getConsulta();
			
			if (listadoVacunacion.size()!=0) {
				for (Vacunacion vacunacion : listadoVacunacion) {
					System.out.println(vacunacion);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dbc.disconnect();
		dbc=null;
		
		*/
		
		DbConnection dbc=new DbConnection();
		Connection cn=dbc.getConnection();
		
		VacunaController vacuna=new VacunaController(cn);
		
		boolean agregado=false;
		
		codVacunacion="50031585677737100444";
		paciente="Jose Antonio";
		tipoVacuna="pFizer";
		fechaNacimiento="1996-06-07";
		primeraDosis="1996-06-07";
		segundaDosis="1996-06-07";
		vacunado="true";
		
		try {
			agregado=vacuna.agregarVacuna(codVacunacion,paciente,tipoVacuna,fechaNacimiento,primeraDosis,segundaDosis,vacunado);
			if (agregado) {
				System.out.println("EL REGISTRO SE AGREGO CON EXITO");
			}else {
				System.err.println("EL REGISTRO NO SE AGREGO CORRECTAMENTE");
			}
		} catch (CodVacunacionException | ParseException | SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		

	}

}
