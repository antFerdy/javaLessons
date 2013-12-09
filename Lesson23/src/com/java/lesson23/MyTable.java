package com.java.lesson23;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;



public class MyTable extends JFrame implements TableModelListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyTableModel model;
	JTable table;
	TableColumn col;

	
	MyTable(String str) {
		super(str);
		model = new MyTableModel();
		table = new JTable(model);
		add(new JScrollPane(table));
		model.addTableModelListener(this);
		
		col = table.getColumnModel().getColumn(3);
		
		col.setCellRenderer(new DefaultTableCellRenderer() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		
			public Component getTableCellRendererComponent( 
		             JTable table, Object value, boolean isSelected, 
		                       boolean hasFocus, int row, int col) {
								
				JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
				if(((Integer)value) < 0) {
					label.setForeground(Color.red);
				}
				
				else {
					label.setForeground(Color.black);
				}
				
				label.setHorizontalAlignment(JLabel.RIGHT);
				
				return label;
				
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		MyTable mt = new MyTable("Positions");
		mt.pack();
		mt.setVisible(true);
		
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		System.out.println("Fuck thise shit!!!");
		
	}

}


class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Portfolio port;
	ArrayList<Order> list;
	MyTableModel() {
		port = new Portfolio();
		Thread load = new Thread(port);
		load.start();
		list = port.list;
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0: return "Id";
		case 1: return "Symbol";
		case 2: return "Price";
		case 3: return "Quantity";
		default: return "";
		
		}
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch(columnIndex) {
		case 0: return list.get(rowIndex).id;
		case 1: return list.get(rowIndex).symbol;
		case 2: return list.get(rowIndex).price;
		case 3: return list.get(rowIndex).quantity;
		default: return "";
		}
		}


	public boolean isCellEditable(int row, int col) {
		if(col == 3) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void setValueAt(Object aValue,
            int rowIndex,
            int columnIndex) {
		if(columnIndex == 3) {
			try {
				list.get(rowIndex).quantity = Integer.parseInt(aValue.toString());
			} catch (Exception e) {
				System.out.println("Fuck thise shit!!!");
			}
			
		}
		
		TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex, columnIndex);
		fireTableChanged(event);
	}
	
	
	
	
	
	
}