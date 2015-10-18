package com.fererlab.city.service;

import com.fererlab.city.model.*;
import com.fererlab.core.model.OIDGenerator;
import com.fererlab.core.service.GenericService;
import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.city.serviceengine.dto.CityIdLongDTO;
import com.fererlab.city.serviceengine.dto.CityOidDTO;
import com.fererlab.city.serviceengine.dto.CityUuidDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "CityServiceEngineImpl", mappedName = "CityServiceEngineImpl")
public class CityServiceEngineImpl implements CityServiceEngine {

    @EJB(name = "OIDGenerator")
    private OIDGenerator oidGenerator;

    @EJB(name = "CopyStrategy")
    private CopyStrategy copyStrategy;

    @EJB(name = "CityIDAuditedServiceImpl")
    private CityIDAuditedService cityIDAuditedService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityIDAudited, Integer> idService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityIDNoAudit, Long> idNoAuditService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityOIDAudited, String> oidService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityOIDNoAudit, String> oidNoAuditService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityUUIDAudited, String> uuidService;

    @EJB(name = "GenericServiceImpl")
    private GenericService<CityUUIDNoAudit, String> uuidNoAuditService;

    @Override
    public CityIdIntegerDTO createModelWithID() {
        // create audited city object with Long ID
        CityIDAudited city = new CityIDAudited();
        city.setName("New York");
        // persist object with its service
        // cityIDAuditedService.create(city);
        // or persist object with generic service
        idService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityIdIntegerDTO());
    }

    @Override
    public CityIdLongDTO createModelWithIDNoAudit() {
        // create city object with Long ID without auditing
        CityIDNoAudit city = new CityIDNoAudit();
        city.setName("Tokyo");
        // persist object
        idNoAuditService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityIdLongDTO());
    }

    @Override
    public CityOidDTO createModelWithOID() {
        // this OID is unique for this object of this type
        String OID = oidGenerator.generate(CityOIDAudited.class);
        // create audited city object with OID
        CityOIDAudited city = new CityOIDAudited(OID);
        city.setName("London");
        // persist object
        oidService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityOidDTO());
    }

    @Override
    public CityOidDTO createModelWithOIDNoAudit() {
        // this OID is unique for this object of this type
        String OID = oidGenerator.generate(CityOIDNoAudit.class);
        // create no audit city object with OID
        CityOIDNoAudit city = new CityOIDNoAudit(OID);
        city.setName("Paris");
        // persist object
        oidNoAuditService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityOidDTO());
    }

    @Override
    public CityUuidDTO createModelWithUUID() {
        // create audited city object with UUID
        CityUUIDAudited city = new CityUUIDAudited();
        city.setName("Chicago");
        // persist object
        uuidService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityUuidDTO());
    }

    @Override
    public CityUuidDTO createModelWithUUIDNoAudit() {
        // create no audit city object with UUID
        CityUUIDNoAudit city = new CityUUIDNoAudit();
        city.setName("Vienna");
        // persist object
        uuidNoAuditService.create(city);
        // persisted object
        return copyStrategy.copy(city, new CityUuidDTO());
    }

    @Override
    public CityIdIntegerDTO findModelWithID(Integer id) {
        return copyStrategy.copy(
                idService.findById(CityIDAudited.class, id),
                new CityIdIntegerDTO());
    }

    @Override
    public CityUuidDTO findModelWithUUID(String uuid) {
        return copyStrategy.copy(
                uuidService.findById(CityUUIDAudited.class, uuid),
                new CityUuidDTO()
        );
    }

    @Override
    public CityOidDTO findModelWithOID(String oid) {
        return copyStrategy.copy(
                oidService.findById(CityOIDAudited.class, oid),
                new CityOidDTO()
        );
    }

    @Override
    public CityIdIntegerDTO updateModelWithIDCityService(Integer id, String name) {
        CityIDAudited city = idService.findById(CityIDAudited.class, id);
        city.setName(name);
        cityIDAuditedService.update(city);
        return copyStrategy.copy(city, new CityIdIntegerDTO());
    }

    @Override
    public CityIdIntegerDTO updateModelWithIDGenericService(Integer id, String name) {
        CityIDAudited city = idService.findById(CityIDAudited.class, id);
        city.setName(name);
        idService.update(city);
        return copyStrategy.copy(city, new CityIdIntegerDTO());
    }

}
