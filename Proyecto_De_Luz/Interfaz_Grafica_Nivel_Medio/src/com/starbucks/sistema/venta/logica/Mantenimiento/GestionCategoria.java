package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Categoria;
import com.starbucks.sistema.venta.logica.Interfaces.CategoriaInterface;

public class GestionCategoria implements CategoriaInterface {

	Connection con = null;
	PreparedStatement pst = null;

	@Override
	public int registrarCategoria(Categoria c) {
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Categoria VALUES(?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, c.getIdCat());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getDescripcion());
			pst.setInt(4, c.getCondicional());

			rs = pst.executeUpdate();
		} catch (Exception e) {

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
	public ArrayList<Categoria> listado() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select nombre from TB_Categoria where condicion = 0";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Categoria c = new Categoria();
				c.setNombre(rs.getString(1));

				System.out.println(rs.getString(1));
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
	public int actualizar(String idCategoria, String nombre, String descripcion, int estado) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "UPDATE TB_Categoria SET `nombre`=?,`descripcion`=?,`condicion`=? WHERE `idCat` =?";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, nombre);
			pst.setString(2, descripcion);
			pst.setInt(3, estado);
			pst.setString(4, idCategoria);

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
	public Categoria listarTodo(String nombre) {

		ResultSet rs = null;
		Categoria c = new Categoria();
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from TB_Categoria where nombre =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {

				c.setIdCat(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setCondicional(rs.getInt(4));
			}
			return c;

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

	public Categoria listarTodoPorCodigo(String Codigo) {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		Categoria c = new Categoria();
		try {
			con = MySQLConexion.getConexion();
			String sql = "select nombre,descripcion,condicion from TB_Categoria where idCat =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, Codigo);
			rs = pst.executeQuery();
			while (rs.next()) {

				c.setNombre(rs.getString(1));
				c.setDescripcion(rs.getString(2));
				c.setCondicional(rs.getInt(3));
			}
			return c;

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

	@Override
	public int Eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Delete  from  `BD_Starbucks`.`TB_Categoria` WHERE `idcat` =?;";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeUpdate();
		} catch (Exception e) {

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

}
