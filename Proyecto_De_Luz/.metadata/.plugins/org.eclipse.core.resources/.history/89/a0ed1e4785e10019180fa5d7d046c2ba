package com.starbucks.sistema.venta.graficas.Frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.starbucks.sistema.venta.entidades.bean.Producto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXlsxDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
public class Reportes2 extends JDialog implements ActionListener {
	
	private static final Logger LOGGER = Logger.getLogger(Reportes2.class.getName());
	
	private JPanel panel;
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public Reportes2(Boolean Condicion, Boolean Condicion2) {
		//setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(104, 24, 415, 239);
		add(panel);
		//setVisible(false);
	}
	
	public Reportes2() {
		super();	
	}

	public void actionPerformed(ActionEvent e) {
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reportes2 dialog = new Reportes2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void ReportesProducto(List<Producto> lista) {
		//setUndecorated(true);
		//setBounds(100, 100, 470, 300);
		//getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		//contentPanel.setLayout(null);
		
		try {
			
			List<Map<String, String>> productos = new ArrayList<Map<String, String>>();
			
			String[] cabecera = new String[] {"codigo", "nombre", "precio"};
			
			for(Producto producto : lista ) {
								
				Map<String, String> data = new HashMap<String, String>();				
				data.put("codigo", producto.getCodigo());
				data.put("nombre", producto.getNombre());
				data.put("precio", producto.getPrecio());				
				productos.add(data);
			}
			
			generarExcel("data\\" + "productos.xlsx", cabecera, productos );
			reporte(cabecera, "productos.xlsx", "lista_producto.jrxml");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Reportes2() {
		//setUndecorated(true);
		//setBounds(100, 100, 470, 300);
		//getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//getContentPane().add(contentPanel, BorderLayout.CENTER);
		//contentPanel.setLayout(null);
		
		try {
			
			List<Map<String, String>> productos = new ArrayList<Map<String, String>>();
			
			String[] cabecera = new String[] {"fecha", "total", "boleta"};
			
			for(int i = 0; i < 10; i++) {
				Venta Venta = new Venta();
				Venta.setFecha("02/07/2018");
				Venta.setBoleta("B00"+i);
				Venta.setTotal(Integer.toString(100 + i));
				
				Map<String, String> data = new HashMap<String, String>();				
				data.put("fecha", Venta.getFecha());
				data.put("total", Venta.getTotal());
				data.put("boleta", Venta.getBoleta());				
				productos.add(data);
			}
						
			generarExcel("data\\" + "ventas.xlsx", cabecera, productos );
			reporte(cabecera, "ventas.xlsx", "lista_ventas.jrxml");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	*/
	public void reporte(String[] cabecera, String archivo, String reporte) throws JRException
	{
		long start = System.currentTimeMillis();
 
		// data source filling
		{
			String[] columnNames = cabecera;
			
			JasperPrint reportFilled;
			JasperViewer viewer;
			
			JRXlsxDataSource dataSource = null;
			try {
				dataSource = new JRXlsxDataSource(JRLoader.getLocationInputStream("data\\" + archivo));
				dataSource.setColumnNames(columnNames);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JasperReport report = JasperCompileManager.compileReport(JRLoader.getLocationInputStream("jasper\\" + reporte));
			
			reportFilled = JasperFillManager.fillReport(report, null, dataSource);
			
			viewer = new JasperViewer(reportFilled);
			viewer.setVisible(true);
			
			System.err.println("Report : CsvDataSourceReport.jasper. Filling time : " + (System.currentTimeMillis() - start));
		}

	}
	
	public void generarExcel(String ruta, String[] cabecera, List<Map<String,String>> datos ) {
		// Creamos el archivo donde almacenaremos la hoja
		// de calculo, recuerde usar la extension correcta,
		// en este caso .xlsx
		File archivo = new File(ruta);

		// Creamos el libro de trabajo de Excel formato OOXML
		Workbook workbook = new XSSFWorkbook();

		// La hoja donde pondremos los datos
		Sheet pagina = workbook.createSheet("Reporte de productos");

		String[] titulos = cabecera;
		
		// Creamos una fila en la hoja en la posicion 0
		int conf = 0;
		Row fila = pagina.createRow(conf++);

		// Creamos el encabezado
		for (int i = 0; i < titulos.length; i++) {
			// Creamos una celda en esa fila, en la posicion
			// indicada por el contador del ciclo
			Cell celda = fila.createCell(i);

			// Indicamos el estilo que deseamos
			// usar en la celda, en este caso el unico
			// que hemos creado		
			celda.setCellValue(titulos[i]);
		}

		// Ahora creamos una fila en la posicion 1
		

		// Y colocamos los datos en esa fila
		for(Map<String, String> row : datos) {
			int conColumna = 0;
			fila = pagina.createRow(conf++);
			for(String cab : cabecera) {
				Cell celda = fila.createCell(conColumna++);
				celda.setCellValue(row.get(cab));
			}			
		}

		// Ahora guardaremos el archivo
		try {
			// Creamos el flujo de salida de datos,
			// apuntando al archivo donde queremos
			// almacenar el libro de Excel
			FileOutputStream salida = new FileOutputStream(archivo);

			// Almacenamos el libro de
			// Excel via ese
			// flujo de datos
			workbook.write(salida);

			// Cerramos el libro para concluir operaciones
			LOGGER.log(Level.INFO, "Archivo creado existosamente en {0}", archivo.getAbsolutePath());

		} catch (Exception ex) {
			LOGGER.log(Level.SEVERE, "Archivo no localizable en sistema de archivos");
		} 
	}

}

