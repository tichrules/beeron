package beeron.ragnar.client.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;

public class PersonTableDataModel extends AbstractTableModel {

	private static final long serialVersionUID = -806494790076575317L;

	private RagnarService ragnarService;

	private ExecutorService executorService;
	private List<Person> people;

	public PersonTableDataModel(RagnarService ragnarService) {
		this.ragnarService = ragnarService;
		executorService = Executors.newSingleThreadExecutor();
		people = Collections.emptyList();
		refresh();
	}

	private enum ColumnId {
		NAME, ACTING
	}

	private void refresh() {
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				final List<Person> newPeople = ragnarService.getPeople();
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						people.clear();
						people.addAll(newPeople);
						fireTableDataChanged();
					}
				});
			}
		});
	}

	/**
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return ColumnId.values().length;
	}

	/**
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return people.size();
	}

	/**
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person person = people.get(rowIndex);
		if (ColumnId.NAME.ordinal() == columnIndex) {
			return person.getName();
		}
		return person.getActing();
	}
}
