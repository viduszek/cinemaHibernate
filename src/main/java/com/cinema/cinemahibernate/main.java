package com.cinema.cinemahibernate;

import com.mysql.cj.Session;
import com.cinema.cinemahibernate.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();

            Customer cust1 = new Customer(); // :)))))
            cust1.setId(0);
            cust1.setName("Jan");
            cust1.setSurname("Ziarkowski");
            entityManager.merge(cust1);

            // entityManager.getTransaction().commit();
            // entityManager.persist(cust1);

            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}