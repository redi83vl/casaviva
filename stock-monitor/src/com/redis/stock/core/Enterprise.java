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
package com.redis.stock.core;

import com.redis.stock.utils.Set;

/**
 *
 * @author Redjan Shabani
 */
public interface Enterprise {
	public String getUid();
	public String getName();
	public String getAddress();
	public String getPhone();
	public String getWebsite();
	public String getEmail();
	
	public Set<Stock> getStocks();
	public Set<Item> getItems();
}
