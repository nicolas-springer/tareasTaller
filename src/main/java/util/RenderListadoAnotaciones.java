package util;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
public class RenderListadoAnotaciones extends DefaultTableCellRenderer{
	
 public Component getTableCellRendererComponent(JTable table, Object value,
		 boolean isSelected, boolean hasFocus, int row, int column) {
	 
	 if(value instanceof JTextArea) {
		 JTextArea txarea = (JTextArea) value;
		 return txarea;
	 }
 
	 return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 }
	
 
}
