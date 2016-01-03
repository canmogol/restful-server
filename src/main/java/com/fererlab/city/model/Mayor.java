package com.fererlab.city.model;

import com.fererlab.core.model.BaseModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "TABLE_MAYOR")
public class Mayor extends BaseModel<Integer> {

    private Integer id;
    private String name;
    private CityIDAudited cityIDAudited;

    @Id
    @Column(name = "M_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "M_NAME", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID_AUDITED")
    public CityIDAudited getCityIDAudited() {
        return cityIDAudited;
    }

    public void setCityIDAudited(CityIDAudited cityIDAudited) {
        this.cityIDAudited = cityIDAudited;
    }
}
