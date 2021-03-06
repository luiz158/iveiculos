package net.iveiculos.iveiculos.dao;

import javax.persistence.NoResultException;

import net.iveiculos.iveiculos.model.Subcategoria;

import org.springframework.stereotype.Repository;

@Repository("subcategoriaDao")
public class SubcategoriaDao extends AbstractGenericDao<Subcategoria> {

	/**
	 * Busca Subcategoria por descricao | nunca deve repetir
	 * @param descricao
	 * @return
	 */
	public Subcategoria getPorDescricao(String descricao) {
		try {
			return (Subcategoria) 
					super.manager.createQuery("Select s from Subcategoria s where s.descricao = :descricao")
					             .setParameter("descricao", descricao)
						         .getSingleResult();
		} catch(NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage() + "descricao="+descricao);
		}
	}

}
