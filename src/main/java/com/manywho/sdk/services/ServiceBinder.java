package com.manywho.sdk.services;

import com.manywho.sdk.services.factories.ConfigurationValuesFactory;
import com.manywho.sdk.services.providers.ConfigurationValuesFactoryProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ConfigurationValuesFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
        bind(ConfigurationValuesFactory.class).to(ConfigurationValuesFactory.class).in(Singleton.class);
    }
}