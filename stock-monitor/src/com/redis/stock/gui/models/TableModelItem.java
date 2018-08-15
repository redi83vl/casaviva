/*
 * Copyright (C) 2018 Redjan Shabani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redis.stock.gui.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Redjan Shabani
 */
public class TableModelItem implements TableModel {
	
//	private final List<Item> items = new ArrayList();
	private final Set<TableModelListener> listeners = new HashSet();

	@Override
	public int getRowCount() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getColumnCount() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String getColumnName(int i) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Class<?> getColumnClass(int i) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Object getValueAt(int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setValueAt(Object o, int i, int i1) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void addTableModelListener(TableModelListener tl) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void removeTableModelListener(TableModelListener tl) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}