package com.fererlab.client.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class MapperDTO {

    private Map<String, Object> map = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getMap() {
        return map;
    }

    @JsonAnySetter
    public void setMap(String key, Object value) {
        this.map.put(key, value);
    }

}
