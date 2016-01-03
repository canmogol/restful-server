package com.fererlab.core.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Stateless(name = "OIDGenerator", mappedName = "OIDGenerator")
@LocalBean
public class OIDGenerator {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    /**
     * {joint-iso-itu-t(2) country(16) tr(792) private-sector(3) fererlab(10000) city(1)}
     * 2.16.792.3.10000.1
     * /Country/792/3/10000/1
     * Get the OID prefix from an OID Manager or somewhere appropriate
     */
    private final String OID_PREFIX = "2.16.792.3.10000.1";

    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public String generate(Class<? extends Model<?>> baseOidModel) {
        // oid should be something like {joint-iso-itu-t(2) country(16) tr(792) private-sector(3) fererlab(10000) city(1) className(11ss11) }
    	
    	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
        String oid;
        try {
            // the name of this class is primary key for OIDSeed
            String className = baseOidModel.getCanonicalName();
            // find the OIDSeed for this class
            OIDSeed oidSeed = entityManager.find(OIDSeed.class, className);
            if (oidSeed == null) {
                // the first call should create an OIDSeed for this class with a sequence starting from 0(zero)
                oidSeed = new OIDSeed();
                oidSeed.setId(className);
                oidSeed.setSequenceCount(0L);
                entityManager.persist(oidSeed);
            }

            // this class' name with its package should create a unique number for OID representation
            String classNameNumeric = numericName(className);

            // this object's (current entity) id should increase by 1(one)
            long nextSequenceNumber = oidSeed.getSequenceCount() + 1;

            // now we have something like 2.16.792.3.10000.1.34342312.1
            oid = OID_PREFIX + "." + classNameNumeric + "." + nextSequenceNumber;

            // increase the oid value for this class and update the OIDSeed
            oidSeed.setSequenceCount(nextSequenceNumber);
            entityManager.persist(oidSeed);

        } catch (Exception e) {
            e.printStackTrace();
            oid = String.valueOf(new Random().nextDouble());
        }
        return oid;
    }

    private String numericName(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte aResult : result) {
            sb.append(Integer.toString((aResult & 0xff) + 0x100, 16).substring(1));
        }
        String str = sb.toString();
        str = str.replaceAll("[^\\d.]", "");
        return str;
    }


}
