package com.lala;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class GeoStateQuery implements PanacheRepository< GeoStateEntity > {

    public List< GeoStateEntity > listByGeoCountryCode( String geoCountryCode ) {

        String jpql = "from GeoStateEntity gs "
                + "join gs.geoCountryEntity gc "
                + "where gc.countryCode = :geoCountryCode ";

        return list( jpql, Sort.by( "gs.stateCode" ), new HashMap< String, Object >( ) {{
            put( "geoCountryCode", geoCountryCode );
        }} );
    }
}
