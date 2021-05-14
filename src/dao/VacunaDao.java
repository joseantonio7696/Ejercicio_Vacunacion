package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Vacunacion;

public class VacunaDao {

Connection cn;

public VacunaDao(Connection cn) {
	
	
	this.cn=cn;
}

public List<Vacunacion> getConsulta(String sql) throws SQLException {
	List<Vacunacion>listadoVacunas=new ArrayList<Vacunacion>();
	
	PreparedStatement pst=cn.prepareStatement(sql);
	
	ResultSet rs=pst.executeQuery();
	
	Vacunacion vacuna;
	
	while (rs.next()) {
		
		int idVacunacion=rs.getInt("idvacunacion");
		String codvacunacion=rs.getString("codvacunacion");
		String paciente=rs.getString("paciente");
		String tipovacuna=rs.getString("tipovacuna");
		Date fechanacimiento=rs.getDate("fechanacimiento");
		Date primeradosis=rs.getDate("primeradosis");
		Date segundadosis=rs.getDate("segundadosis");
		boolean vacunado=rs.getBoolean("vacunado");
		
		vacuna=new Vacunacion(idVacunacion, codvacunacion, paciente, tipovacuna, fechanacimiento, primeradosis, segundadosis, vacunado);
		
		listadoVacunas.add(vacuna);
		
		vacuna=null;
		
		
	}
	
	pst=null;
	rs=null;
	
	
	return listadoVacunas;
}

public boolean agregarVacuna(String sql, Vacunacion vacuna) throws SQLException {
	boolean agregado=false;
	
	
	PreparedStatement pst=cn.prepareStatement(sql);
	
	pst.setInt(1, 0);
	pst.setString(2, vacuna.getCodVacunacion());
	pst.setString(3, vacuna.getPaciente());
	pst.setString(4, vacuna.getTipoVacuna());
	pst.setDate(5, vacuna.getFechaNacimiento());
	pst.setDate(6, vacuna.getPrimeraDosis());
	pst.setDate(7, vacuna.getSegundaDosis());
	pst.setBoolean(8, vacuna.isVacunado());
	
	pst.executeUpdate();
	agregado=true;
	
	return agregado;
}

}
