package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.logica.Interfaces.IngresarInterface;

public class GestionIngresar implements IngresarInterface {
	public int Ingresar(String User, String Password) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select pasword from TB_Empleado where id_Empleado =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, User);
			rs = pst.executeQuery();
			int total = 0;
			while (rs.next()) {
				total++;
				if (total == 1 && rs.getString(1).equals(Password)) {
					return 1;
				}
			}

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

	public String Ingresa(String User) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String Cargo;
			con = MySQLConexion.getConexion();
			String sql = "select cargo from TB_Empleado where id_Empleado =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, User);
			rs = pst.executeQuery();

			while (rs.next()) {
				Cargo = rs.getString(1);
				return Cargo;
			}

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
		return null;

	}
}
