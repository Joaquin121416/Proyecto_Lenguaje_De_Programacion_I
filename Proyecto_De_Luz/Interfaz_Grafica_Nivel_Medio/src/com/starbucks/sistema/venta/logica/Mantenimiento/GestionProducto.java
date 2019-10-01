package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Producto;
import com.starbucks.sistema.venta.logica.Interfaces.ProductoInterface;

public class GestionProducto implements ProductoInterface {

	@Override
	public int RegistrarProducto(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Producto VALUES(?,?,?,?,?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, p.getCodigoProducto());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getDescripcion());
			pst.setString(4, p.getId_Categoria());
			pst.setString(5, p.getPath());
			pst.setDouble(6, p.getPrecioCompra());
			pst.setDouble(7, p.getPrecioVenta());
			pst.setInt(8, p.getEstado());
			rs = pst.executeUpdate();
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Error al conectar a la Base de Datos");
			e.printStackTrace();
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
	public int Eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Delete  from  `BD_Starbucks`.`TB_Producto` WHERE `Id_Producto` =?;";

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

	@Override
	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select  `Id_Producto`,`nombre`,`precio_venta` from TB_Producto";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigoProducto(rs.getString(1));
				p.setDescripcion(rs.getString(2));
				p.setNombre(p.getDescripcion());
				p.setPrecioVenta(rs.getDouble(3));
				lista.add(p);

			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia");
			e.printStackTrace();
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
	public int Actualizar(String codigo, String nombre, String descripcion, String Categoria, String path, int estado,
			double precioCompra, double precioVenta) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "UPDATE `BD_Starbucks`.`TB_Producto` SET `nombre`=?,`descripcion`=?,`idcat`=?,`path_imagen`=?,`estado`=?,`precio_compra`=?,`precio_venta`=?   WHERE `id_producto` =?";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, nombre);
			pst.setString(2, descripcion);
			pst.setString(3, Categoria);
			pst.setString(4, path);
			pst.setInt(5, estado);
			pst.setDouble(6, precioCompra);
			pst.setDouble(7, precioVenta);
			pst.setString(8, codigo);

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
	public Producto listadoTodo(String codigo) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = " SELECT * FROM TB_Producto where `id_producto`=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigoProducto(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setId_Categoria(rs.getString(4));
				p.setPath(rs.getString(5));
				p.setPrecioCompra(rs.getDouble(6));
				p.setPrecioVenta(rs.getDouble(7));
				p.setEstado(rs.getInt(8));
				return p;
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

	public ResultSet listadoResult() {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select  `id_producto`,`nombre`,`precio_Venta` from TB_Producto";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();

		} catch (Exception e) {
			System.out.println("Error en la sentencia");
			e.printStackTrace();
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

	public String LLamarPath(String Codigo) {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = " SELECT path_imagen FROM TB_Producto where `id_producto`=?";

			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, Codigo);
			rs = pst.executeQuery();
			while (rs.next()) {
				String cad = rs.getString(1);
				return cad;
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia");
			e.printStackTrace();
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
