package com.fererlab.city;

import com.fererlab.city.model.*;
import com.fererlab.city.service.CityIDAuditedService;
import com.fererlab.core.model.OIDGenerator;
import com.fererlab.core.service.GenericService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class CityServiceEngine {

    @EJB
    private OIDGenerator oidGenerator;

    @EJB(name = "CityIDAuditedServiceImpl")
    private CityIDAuditedService cityIDAuditedService;

    @EJB
    private GenericService<CityIDAudited, Integer> idService;

    @EJB
    private GenericService<CityIDNoAudit, Long> idNoAuditService;

    @EJB
    private GenericService<CityOIDAudited, String> oidService;

    @EJB
    private GenericService<CityOIDNoAudit, String> oidNoAuditService;

    @EJB
    private GenericService<CityUUIDAudited, String> uuidService;

    @EJB
    private GenericService<CityUUIDNoAudit, String> uuidNoAuditService;

    public CityIDAudited createModelWithID() {
        // create audited city object with Long ID
        CityIDAudited city = new CityIDAudited();
        city.setName("Elazig");
        // persist object with its service
        // cityIDAuditedService.create(city);
        // or persist object with generic service
        idService.create(city);
        // persisted object
        return city;
    }

    public CityIDNoAudit createModelWithIDNoAudit() {
        // create city object with Long ID without auditing
        CityIDNoAudit city = new CityIDNoAudit();
        city.setName("Bayburt");
        // persist object
        idNoAuditService.create(city);
        // persisted object
        return city;
    }

    public CityOIDAudited createModelWithOID() {
        // this OID is unique for this object of this type
        String OID = oidGenerator.generate(CityOIDAudited.class);
        // create audited city object with OID
        CityOIDAudited city = new CityOIDAudited(OID);
        city.setName("Bitlis");
        // persist object
        oidService.create(city);
        // persisted object
        return city;
    }

    public CityOIDNoAudit createModelWithOIDNoAudit() {
        // this OID is unique for this object of this type
        String OID = oidGenerator.generate(CityOIDNoAudit.class);
        // create no audit city object with OID
        CityOIDNoAudit city = new CityOIDNoAudit(OID);
        city.setName("Malatya");
        // persist object
        oidNoAuditService.create(city);
        // persisted object
        return city;
    }

    public CityUUIDAudited createModelWithUUID() {
        // create audited city object with UUID
        CityUUIDAudited city = new CityUUIDAudited();
        city.setName("Mus");
        // persist object
        uuidService.create(city);
        // persisted object
        return city;
    }

    public CityUUIDNoAudit createModelWithUUIDNoAudit() {
        // create no audit city object with UUID
        CityUUIDNoAudit city = new CityUUIDNoAudit();
        city.setName("Mus");
        // persist object
        uuidNoAuditService.create(city);
        // persisted object
        return city;
    }

    public CityIDAudited findModelWithID(Integer id) {
        return idService.findById(CityIDAudited.class, id);
    }

    public CityUUIDAudited findModelWithUUID(String uuid) {
        return uuidService.findById(CityUUIDAudited.class, uuid);
    }

    public CityOIDAudited findModelWithOID(String oid) {
        return oidService.findById(CityOIDAudited.class, oid);
    }

    public CityIDAudited updateModelWithIDCityService(Integer id, String name) {
        CityIDAudited city = idService.findById(CityIDAudited.class, id);
        city.setName(name);
        cityIDAuditedService.update(city);
        return city;
    }

    public CityIDAudited updateModelWithIDGenericService(Integer id, String name) {
        CityIDAudited city = idService.findById(CityIDAudited.class, id);
        city.setName(name);
        idService.update(city);
        return city;
    }

}
