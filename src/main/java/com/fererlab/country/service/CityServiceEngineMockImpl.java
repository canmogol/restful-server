package com.fererlab.country.service;

import com.fererlab.city.serviceengine.CityServiceEngine;
import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.city.serviceengine.dto.CityIdLongDTO;
import com.fererlab.city.serviceengine.dto.CityOidDTO;
import com.fererlab.city.serviceengine.dto.CityUuidDTO;
import com.fererlab.core.selector.MockServiceQualifier;

import javax.ejb.Stateless;

@MockServiceQualifier
@Stateless(name = "CityServiceEngineMockImpl", mappedName = "CityServiceEngineMockImpl")
public class CityServiceEngineMockImpl implements CityServiceEngine {
    @Override
    public CityIdIntegerDTO createModelWithID() {
        return new CityIdIntegerDTO();
    }

    @Override
    public CityIdLongDTO createModelWithIDNoAudit() {
        return new CityIdLongDTO();
    }

    @Override
    public CityOidDTO createModelWithOID() {
        return new CityOidDTO();
    }

    @Override
    public CityOidDTO createModelWithOIDNoAudit() {
        return new CityOidDTO();
    }

    @Override
    public CityUuidDTO createModelWithUUID() {
        return new CityUuidDTO();
    }

    @Override
    public CityUuidDTO createModelWithUUIDNoAudit() {
        return new CityUuidDTO();
    }

    @Override
    public CityIdIntegerDTO findModelWithID(Integer id) {
        return new CityIdIntegerDTO();
    }

    @Override
    public CityIdIntegerDTO findCityWithCountryName(String countryName) {
        return new CityIdIntegerDTO("New York Mock", "USA");
    }

    @Override
    public CityUuidDTO findModelWithUUID(String uuid) {
        return new CityUuidDTO();
    }

    @Override
    public CityOidDTO findModelWithOID(String oid) {
        return new CityOidDTO();
    }

    @Override
    public CityIdIntegerDTO deleteModelWithIDCityService(Integer id) {
        return new CityIdIntegerDTO();
    }

    @Override
    public CityIdIntegerDTO updateModelWithIDCityService(Integer id, String name) {
        return new CityIdIntegerDTO();
    }

    @Override
    public CityIdIntegerDTO updateModelWithIDGenericService(Integer id, String name) {
        return new CityIdIntegerDTO();
    }
}
