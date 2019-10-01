package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.logica.Interfaces.ValidacionesSQLInterface;;

public class GestionValidacionesSQL implements ValidacionesSQLInterface {

	@Override
	public int ValidarCodigoRepetido(String Codigo, String Tabla, String Campo) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select ";
			sql = sql.concat(Campo);
			sql = sql.concat(" from ");
			sql = sql.concat(Tabla);
			sql = sql.concat(" where ");
			sql = sql.concat(Campo);
			sql = sql.concat(" =?");
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, Codigo);
			rs = pst.executeQuery();
			int total = 0;
			while (rs.next()) {
				total++;
				if (total > 0) {
					return 0;
				}
			}

			return 1;

		} catch (Exception e) {
			System.out.println("Error en la sentencia");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}

		}
		return 0;
	}

}
