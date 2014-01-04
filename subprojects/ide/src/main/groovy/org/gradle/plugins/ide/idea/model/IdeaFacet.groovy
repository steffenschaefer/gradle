package org.gradle.plugins.ide.idea.model

/**
 *
 */
abstract class IdeaFacet {
    String name;
    final String type;
    final boolean unique;

    IdeaFacet(String type) {
        this(type, false);
    }

    IdeaFacet(String type, boolean unique) {
        this.type = type;
        this.unique = unique;
    }

    protected Facet create(PathFactory pathFactory) {
        Facet facet = createFacet(pathFactory)
        facet.name = getName()
        facet.type = getType()
        facet.unique = isUnique()
        return facet
    }

    protected abstract Facet createFacet(PathFactory pathFactory);
}
