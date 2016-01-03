package com.fererlab.city.model;

import com.fererlab.core.model.BaseModelIDAudited;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Audited
@Entity
@Table(name = "CITY_ID_AUDITED")
public class CityIDAudited extends BaseModelIDAudited<Integer> implements City<Integer> {

    private static final long serialVersionUID = -5819948978970016787L;

    private String name;

    private List<Mayor> mayorList;

    public CityIDAudited() {
    }

    public CityIDAudited(String name) {
        this.name = name;
    }

    @Column(name = "CT_NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotAudited
    @OneToMany(mappedBy = "cityIDAudited")
    public List<Mayor> getMayorList() {
        return mayorList;
    }

    public void setMayorList(List<Mayor> mayorList) {
        this.mayorList = mayorList;
    }

}
