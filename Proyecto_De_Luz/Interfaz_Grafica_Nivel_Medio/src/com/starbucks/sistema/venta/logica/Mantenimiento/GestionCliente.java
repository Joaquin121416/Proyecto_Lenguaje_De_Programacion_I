package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Cliente;
import com.starbucks.sistema.venta.logica.Interfaces.ClienteInterface;

public class GestionCliente implements ClienteInterface {

	@Override
	public int registrarCliente(Cliente c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Cliente VALUES(?,?,?,?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, c.getIdCliente());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getApellido());
			pst.setInt(4, c.getNumDocu());
			pst.setString(5, c.getTipoDoc());
			pst.setInt(6, c.getTipoCliente());
			pst.setInt(7, c.getNumPunt());

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
	public int Eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Delete  from  `TB_Cliente` WHERE id_cliente =?;";

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
	public ArrayList<Cliente> listado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizar(String IdCliente, String Nombre, String Apellido, int NumDocu, String TipoDoc,
			int TipoCliente, int NumPunt) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "UPDATE TB_Cliente SET `nombre`=?,`apellido`=?,`nmr_Documento`=? ,tipo_documento=?,tipo_cliente=?,nmr_puntos=?  WHERE `id_cliente` =?";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, Nombre);
			pst.setString(2, Apellido);
			pst.setInt(3, NumDocu);
			pst.setString(4, TipoDoc);
			pst.setInt(5, TipoCliente);
			pst.setInt(6, NumPunt);
			pst.setString(7, IdCliente);

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
	public Cliente listarTodo(String IdCliente) {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		Cliente c = new Cliente();
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from TB_Cliente where id_cliente =?";
			pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, IdCliente);
			rs = pst.executeQuery();
			while (rs.next()) {

				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(3));
				c.setNumDocu(rs.getInt(4));
				c.setTipoDoc(rs.getString(5));
				c.setTipoCliente(rs.getInt(6));
				c.setNumPunt(rs.getInt(7));
			}
			return c;

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
