package com.lala;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "/geo-states" )
public class GeoStateResource {

    @Inject
    GeoStateQuery geoStateQuery;

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public void listGeoStatesByGeoCountryCode(
            @QueryParam( "geoCountryCode" ) String geoCountryCode,
            @Suspended final AsyncResponse resp ) {

        List< GeoStateEntity > geoStateEntityList = geoStateQuery.listByGeoCountryCode( geoCountryCode );

        CacheControl cc = new CacheControl( );
        cc.setNoStore( true );
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setPrivate( true );
        cc.setMustRevalidate( true );

        resp.resume( Response.status( Response.Status.OK ).cacheControl( cc )
                .entity( geoStateEntityList )
                .build( ) );
    }
}