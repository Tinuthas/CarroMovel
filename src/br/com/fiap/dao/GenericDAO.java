package br.com.fiap.dao;

import br.com.fiap.excecao.CommitException;
import br.com.fiap.excecao.SearchNotFoundException;

public interface GenericDAO<T, K> {

	void create(T entity);

	T read(K key) throws SearchNotFoundException;

	void update(T entity);

	void delete(K key) throws SearchNotFoundException;

	void commit() throws CommitException;

}
