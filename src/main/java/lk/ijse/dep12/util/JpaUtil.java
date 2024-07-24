package lk.ijse.dep12.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf =buildEmf();

    private static EntityManagerFactory buildEmf() {
        return Persistence.createEntityManagerFactory("dep-12");
    }

    public static EntityManagerFactory getEmf(){
        return emf;
    }

}
