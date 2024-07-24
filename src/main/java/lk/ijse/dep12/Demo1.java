package lk.ijse.dep12;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.entity.*;
import lk.ijse.dep12.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = JpaUtil.getEmf();
        EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();

                Customer kasun = new Customer("C001", "Kasun", "galle");
                Customer nuwan = new Customer("C002", "Nuwan", "matara");

                Contact kasunContact1 = new Contact("087-2457924", kasun);
                Contact kasunContact2 = new Contact("011-4334434", kasun);
                Contact nuwanContact1 = new Contact("055-2222444", nuwan);

                User user1 = new User("kassa", "kasun", "123");
                User user2 = new User("nuwa", "nuwan", "123");

                Item item1 = new Item("I001", "mouse", 10, new BigDecimal("200"));
                Item item2 = new Item("I002", "monitor", 10, new BigDecimal("1000"));

                Order od001 = new Order("OD001", kasun, user1);
                Order od002 = new Order("OD002", nuwan, user1);

                OrderItem orderItem1 = new OrderItem(od001, item1, new BigDecimal("10000"), 5);
                OrderItem orderItem2 = new OrderItem(od002, item1, new BigDecimal("7000"), 5);

                List.of(kasun,nuwan,kasunContact1,kasunContact2,nuwanContact1,user1,user2,
                        item1,item2,od001,od002,orderItem1,orderItem2).forEach(em::persist);



                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            }

        }
    }
}