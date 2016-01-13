package com.fererlab.core.selector;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Provider;

public abstract class ServiceSelector<I> {

    @Inject
    Provider<I> provider;

    @Inject
    @MockServiceQualifier
    Instance<I> alternatives;

    public I select() {

        I service = null;

        try {
            service = provider.get();
        } catch (Exception e) {
            service = alternatives.get();
        }

        return service;
    }

}
