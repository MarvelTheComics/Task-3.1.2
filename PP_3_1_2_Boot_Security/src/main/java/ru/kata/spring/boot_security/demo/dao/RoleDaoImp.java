package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImp implements RoleDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Role getRole(Integer id) {
        return em.find(Role.class, id);
    }
}
