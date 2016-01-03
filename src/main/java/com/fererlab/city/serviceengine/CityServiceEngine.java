package com.fererlab.city.serviceengine;


import com.fererlab.city.serviceengine.dto.CityIdIntegerDTO;
import com.fererlab.city.serviceengine.dto.CityIdLongDTO;
import com.fererlab.city.serviceengine.dto.CityOidDTO;
import com.fererlab.city.serviceengine.dto.CityUuidDTO;

import javax.ejb.Local;

@Local
public interface CityServiceEngine {

    CityIdIntegerDTO createModelWithID();

    CityIdLongDTO createModelWithIDNoAudit();

    CityOidDTO createModelWithOID();

    CityOidDTO createModelWithOIDNoAudit();

    CityUuidDTO createModelWithUUID();

    CityUuidDTO createModelWithUUIDNoAudit();

    CityIdIntegerDTO findModelWithID(Integer id);

    CityUuidDTO findModelWithUUID(String uuid);

    CityOidDTO findModelWithOID(String oid);

    CityIdIntegerDTO deleteModelWithIDCityService(Integer id);

    CityIdIntegerDTO updateModelWithIDCityService(Integer id, String name);

    CityIdIntegerDTO updateModelWithIDGenericService(Integer id, String name);
}
