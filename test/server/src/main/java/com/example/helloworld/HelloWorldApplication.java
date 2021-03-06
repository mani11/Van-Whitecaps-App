package com.example.helloworld;

import org.hibernate.SessionFactory;
import java.util.*;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;

import com.example.helloworld.core.Player;
import com.example.helloworld.core.Template;
import com.example.helloworld.db.PlayerDAO;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.resources.PlayersResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import java.util.Map;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    private final HibernateBundle<HelloWorldConfiguration> hibernateBundle =
        new HibernateBundle<HelloWorldConfiguration>(Player.class) {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };

    @Override
    public String getName() {
        return "players";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {

        //Attemp to fix the issue of No context found in hibernate
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.setDefaultReadOnly(true);
        session.setCacheMode(CacheMode.NORMAL);
        session.setFlushMode(FlushMode.MANUAL); 
        ManagedSessionContext.bind(session);
        final PlayerDAO dao = new PlayerDAO(sessionFactory);
        // final PlayerDAO dao = new PlayerDAO(hibernateBundle.getSessionFactory());
        final Template template = configuration.buildTemplate();

        environment.jersey().register(new HelloWorldResource(template));
        environment.jersey().register(new PlayersResource(dao));

        // TODO add your resources here
    }
}
