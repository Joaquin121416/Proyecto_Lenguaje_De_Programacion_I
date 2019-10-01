package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Empleado;
import com.starbucks.sistema.venta.logica.Interfaces.EmpleadoInterface;

public class GestionEmpleado implements EmpleadoInterface {

	@Override
	public int registrarEmpleado(Empleado e) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Empleado VALUES(?,?,?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, e.getIdEmpleado());
			pst.setString(2, e.getNombre());
			pst.setString(3, e.getApellidos());
			pst.setString(4, e.getDni());
			pst.setString(5, e.getCargo());
			pst.setString(6, e.getPassword());

			rs = pst.executeUpdate();
		} catch (Exception e1) {

			JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar");

			}

		}
		return rs;

	}

	@Override
	public int eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Delete  from  `TB_Empleado` WHERE id_Empleado =?;";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos");
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
		return rs;
	}

	@Override
	public ArrayList<Empleado> listado() {
		ArrayList<Empleado> lista = new ArrayList<Empleado>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select id_Empleado,nombre,apellidos,dni,cargo from TB_Empleado";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Empleado e = new Empleado();
				e.setIdEmpleado(rs.getString(1));
				e.setNombre(rs.getString(2));
				e.setApellidos(rs.getString(3));
				e.setDni(rs.getString(4));
				e.setCargo(rs.getString(5));

				lista.add(e);
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
		return lista;
	}

	@Override
	public int actualizar(String idEm, String nom, String ape, String dni, String car) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "UPDATE TB_Empleado SET `nombre`=?,`apellidos`=?,`dni`=? ,cargo=?  WHERE `id_Empleado` =?";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, nom);
			pst.setString(2, ape);
			pst.setString(3, dni);
			pst.setString(4, car);
			pst.setString(5, idEm);

			rs = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos");
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
		return rs;

	}

	@Override
	public Empleado listarTodoporCodigo(String cod) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		Empleado e = new Empleado();
		try {
			con = MySQLConexion.getConexion();
			String sql = "select nombre,apellidos,dni,cargo from TB_Empleado where id_Empleado =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, cod);
			rs = pst.executeQuery();
			while (rs.next()) {

				e.setNombre(rs.getString(1));
				e.setApellidos(rs.getString(2));
				e.setDni(rs.getString(3));
				e.setCargo(rs.getString(4));
			}
			return e;

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error en la sentencia");
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();

			} catch (SQLException ex) {
				System.out.println("Error al cerrar");
			}

		}
		return null;
	}

}
