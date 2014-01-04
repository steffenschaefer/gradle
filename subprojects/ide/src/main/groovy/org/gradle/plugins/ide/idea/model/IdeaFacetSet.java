package org.gradle.plugins.ide.idea.model;

import groovy.lang.Closure;
import org.gradle.api.Action;
import org.gradle.api.DomainObjectSet;

/**
 *
 */
public interface IdeaFacetSet extends DomainObjectSet<IdeaFacet> {
    <F extends IdeaFacet> F facet(String name, Class<F> type, Object... parameters);

    <F extends IdeaFacet> F facet(String name, Class<F> type, Action<? super F> action);

    <F extends IdeaFacet> F facet(String name, Class<F> type, Closure action);
}
