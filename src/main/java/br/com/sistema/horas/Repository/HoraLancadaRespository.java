package br.com.sistema.horas.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sistema.horas.Domain.HoraLancada;
import br.com.sistema.horas.Domain.Usuario;

public class HoraLancadaRespository {

	private EntityManager manager;

	@Inject
	public HoraLancadaRespository(EntityManager manager){
		this.manager = manager;
		
	}
	
	public HoraLancadaRespository(){}
	
//	public List<HoraLancada> lista() {
//		String jpql ="select h from HoraLancada h";
//	  TypedQuery<HoraLancada> query = manager.createQuery(jpql,HoraLancada.class);
//		return query.getResultList();
//	}

	public void adiciona(HoraLancada horaLancada) {
		manager.getTransaction().begin();
		manager.persist(horaLancada);
		manager.getTransaction().commit();
	}


	public List<HoraLancada> lista() {
		TypedQuery<HoraLancada> query = this.manager.createQuery("select hl from HoraLancada hl", HoraLancada.class);
		return query.getResultList();
	}
	

	public List<HoraLancada> horasDoUsuario(Usuario usuario) {
		TypedQuery<HoraLancada> query = this.manager.createQuery("select h from HoraLancada h where h.usuario = :usuario order by h.data", HoraLancada.class);
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}
}
