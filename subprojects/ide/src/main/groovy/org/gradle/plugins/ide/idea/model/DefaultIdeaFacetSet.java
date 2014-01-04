package org.gradle.plugins.ide.idea.model;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.internal.DefaultDomainObjectSet;
import org.gradle.internal.reflect.Instantiator;
import org.gradle.util.ConfigureUtil;

/**
 *
 */
public class DefaultIdeaFacetSet extends DefaultDomainObjectSet<IdeaFacet> implements IdeaFacetSet {

    private final Instantiator instantiator;

    DefaultIdeaFacetSet(Instantiator instantiator) {
        super(IdeaFacet.class);
        this.instantiator = instantiator;
    }

    public <F extends IdeaFacet> F facet(String name, Class<F> type, Object... parameters) {
        F facet = instantiator.newInstance(type, parameters);
        facet.setName(name);
        add(facet);
        return facet;
    }

    public <F extends IdeaFacet> F facet(String name, Class<F> type, Action<? super F> action) {
        F facet = facet(name, type);
        action.execute(facet);
        return facet;
    }

    public <F extends IdeaFacet> F facet(String name, Class<F> type, Closure action) {
        F facet = facet(name, type);
        ConfigureUtil.configure(action, facet);
        return facet;
    }

}
