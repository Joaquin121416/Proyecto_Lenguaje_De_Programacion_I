package com.starbucks.sistema.venta.logica.Mantenimiento;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.starbucks.sistema.venta.datos.utils.MySQLConexion;
import com.starbucks.sistema.venta.entidades.Clases.Detalle;
import com.starbucks.sistema.venta.entidades.Clases.DocumentoVenta;
import com.starbucks.sistema.venta.logica.Interfaces.VentaInterface;

public class GestionVenta implements VentaInterface {

	@Override
	public int InsertarDocVenta(DocumentoVenta doc) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Documento_Venta VALUES(?,?,?,?,?,?,?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, doc.getIdVenta());
			pst.setString(2, doc.getIdCliente());
			pst.setString(3, doc.getIdCatPago());
			pst.setString(4, doc.getIdEmp());
			pst.setInt(5, doc.getNumBoleta());
			pst.setDouble(6, doc.getImporteBruto());
			pst.setDouble(7, doc.getIGV());
			pst.setDouble(8, doc.getImporteNeto());
			pst.setInt(9, doc.getEstado());
			pst.setString(10, doc.getFecha());
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
	public int insertarDettalle(Detalle det) {

		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();

			String sql = "INSERT INTO TB_Detalle_Doc_venta VALUES(?,?,?,?,?)";

			pst = (PreparedStatement) con.prepareStatement(sql);

			pst.setString(1, det.getCod_deta());
			pst.setString(2, det.getCod_pro());
			pst.setString(3, det.getCod_ven());
			pst.setDouble(4, det.getPrecio());
			pst.setInt(5, det.getCan());
			
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

	public String UltimoBol() {

		String Cod;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select id_Venta from TB_Documento_Venta order by id_Venta desc LIMIT 1 ";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Cod = rs.getString(1);
				return Cod;
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
	
	public String UltimoDet() {

		String Cod;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select id_detalle from TB_Detalle_Doc_venta order by id_detalle desc LIMIT 1 ";

			pst = (PreparedStatement) con.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Cod = rs.getString(1);
				return Cod;
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
