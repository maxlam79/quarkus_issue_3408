package com.lala;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Cacheable
@Table( name = "t_geo_state" )
public class GeoStateEntity extends PanacheEntityBase {

    @Id
    @Column( name = "uuid" )
    public String uuid;

    @JoinColumn( name = "country_code", referencedColumnName = "country_code" )
    @ManyToOne( fetch = FetchType.LAZY )
    @JsonbTransient
    public GeoCountryEntity geoCountryEntity;

    @Column( name = "state_code" )
    public String stateCode;

    @Column( name = "state_name" )
    public String stateName;

    public GeoStateEntity( ) {
    }

    public GeoStateEntity( String uuid, GeoCountryEntity geoCountryEntity, String stateCode, String stateName ) {
        this.uuid = uuid;
        this.geoCountryEntity = geoCountryEntity;
        this.stateCode = stateCode;
        this.stateName = stateName;
    }
}
