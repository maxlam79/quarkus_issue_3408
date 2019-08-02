package com.lala;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@Table( name = "t_geo_country" )
public class GeoCountryEntity extends PanacheEntityBase {

    @Id
    @Column( name = "country_code" )
    public String countryCode;

    @Column( name = "country_name" )
    public String countryName;

    public GeoCountryEntity( ) {
    }

    public GeoCountryEntity( String countryCode, String countryName ) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    // ---------- Other Associations ----------
    @OneToMany( mappedBy = "geoCountryEntity", fetch = FetchType.LAZY )
    @JsonbTransient
    public List< GeoStateEntity > geoStateEntityList;
}
