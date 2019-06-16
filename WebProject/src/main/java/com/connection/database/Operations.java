package com.connection.database;

import java.util.List;

public interface Operations<K,V> {

	public V update(K value);
	public V insert(K value);
	public V delete(K value);
	default V find(K value)
	{
		return null;
	}
	static void meth1()
	{
		
	}
	
	public List<V> findAll(K value);
	
}
