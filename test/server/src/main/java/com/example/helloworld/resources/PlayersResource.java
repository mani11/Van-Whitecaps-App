package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.Saying;
import com.example.helloworld.core.Template;
import com.example.helloworld.db.PlayerDAO;
import com.example.helloworld.core.Player;
import io.dropwizard.jersey.caching.CacheControl;
import org.hibernate.Session;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerResource.class);

    private final PlayerDAO dao;
     public PlayerResource(PlayerDAO dao) { 
        this.dao = dao;
    }
    @GET
    @Timed(name = "get-requests")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public List<Player> getPlayers() {
    List<Player> l = this.dao.findAll();
    return l;
    }    
}



