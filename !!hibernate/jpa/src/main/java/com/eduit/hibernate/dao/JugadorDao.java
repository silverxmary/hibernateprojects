package com.eduit.hibernate.dao;

import com.eduit.hibernate.model.Jugador;

import javax.persistence.EntityManager;

/**
 * Created by marcelo-fazzito on 08/06/15.
 */
public class JugadorDao extends GenericDao<Jugador,Long> {

    public JugadorDao(EntityManager entityManager) {
        super(entityManager);
    }

}
