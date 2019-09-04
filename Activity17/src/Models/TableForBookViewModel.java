package Models;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Activity17.MyDBHelper;


//--------------------------------------------------------------------------
//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#data
//--------------------------------------------------------------------------
public class TableForBookViewModel extends AbstractTableModel  {

	private List<BookViewModel> _BookViewModels;

	public TableForBookViewModel(Vector<BookViewModel> BookViewModel) {
		this._BookViewModels = new ArrayList<BookViewModel>(BookViewModel);
	}

	@Override
	public int getColumnCount() {
		return 7;//_BookViewModels.getClass().getDeclaredFields().length;
	}

	@Override
	public int getRowCount() {
		return _BookViewModels.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Name";
		case 2:
			return "Author";
		case 3:
			return "Price";
		case 4:
			return "Discount";
		case 5:
			return "Image";
		case 6:
			return "CatName";
		default:
			return "";
		}
	}
	
	public void addRow(BookViewModel s) 
	{
		//_BookViewModels.add(new BookViewModel(s.getId(), s.getName(), s.getAddress()));
		fireTableDataChanged();
	}

	@Override
	public boolean isCellEditable(int row, int col)
	{ return true; }

	@Override
	public Object getValueAt(int row, int column) {
		BookViewModel s = _BookViewModels.get(row);
		switch (column) {
		case 0:
			return s.getId();
		case 1:
			return s.getName();
		case 2:
			return s.getAuthor();
		case 3:
			return s.getPrice();
		case 4:
			return s.getDiscount();
		case 5:
			return s.getImage();
		case 6:
			return s.getCatName();
		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int row, int column) {
		BookViewModel s = _BookViewModels.get(row);
		switch (column) {
		case 0:
			super.setValueAt(s.getId(), row, column);
		case 1:
			super.setValueAt(s.getName(), row, column);
		case 2:
			super.setValueAt(s.getAuthor(), row, column);
		case 3:
			super.setValueAt(s.getPrice(), row, column);
		case 4:
			super.setValueAt(s.getDiscount(), row, column);
		case 5:
			super.setValueAt(s.getImage(), row, column);
		case 6:
			super.setValueAt(s.getCatName(), row, column);
		}
	}
	
	public BookViewModel getBookViewModelAt(int row) {
        return _BookViewModels.get(row);
    }

	public void refresh(Vector<BookViewModel> rows) {
		this._BookViewModels = new ArrayList<BookViewModel>(rows);
		fireTableDataChanged();
    }
}
