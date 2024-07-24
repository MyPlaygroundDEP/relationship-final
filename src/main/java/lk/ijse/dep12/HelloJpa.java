package lk.ijse.dep12;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.util.JpaUtil;

public class HelloJpa {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = JpaUtil.getEmf();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                System.out.println(em);
                System.out.println(emf);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            }

        }
    }
}