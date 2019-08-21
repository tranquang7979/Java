package Acitivity15.ui;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Acitivity15.Student;

//--------------------------------------------------------------------------
//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#data
//--------------------------------------------------------------------------
public class TableModelCustom extends AbstractTableModel  {

	private List<Student> _students;

	public TableModelCustom(Vector<Student> student) {
		this._students = new ArrayList<Student>(student);
	}

	@Override
	public int getColumnCount() {
		return 3;//_students.getClass().getDeclaredFields().length;
	}

	@Override
	public int getRowCount() {
		return _students.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Name";
		case 2:
			return "Address";
		default:
			return "";
		}
	}
	
	public void addRow(Student s) 
	{
		_students.add(new Student(s.getId(), s.getName(), s.getAddress()));
		fireTableDataChanged();
	}

	@Override
	public boolean isCellEditable(int row, int col)
	{ return true; }

	@Override
	public Object getValueAt(int row, int column) {
		Student s = _students.get(row);
		switch (column) {
		case 0:
			return s.getId();
		case 1:
			return s.getName();
		case 2:
			return s.getAddress();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		Student s = _students.get(row);
		switch (column) {
		case 0:
			super.setValueAt(s.getId(), row, column);
		case 1:
			super.setValueAt(s.getName(), row, column);
		case 2:
			super.setValueAt(s.getAddress(), row, column);
		}
	}
	
	public Student getStudentAt(int row) {
        return _students.get(row);
    }
}
