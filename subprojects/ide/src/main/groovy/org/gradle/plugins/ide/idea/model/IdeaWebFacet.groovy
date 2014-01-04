package org.gradle.plugins.ide.idea.model

/**
 *
 */
class IdeaWebFacet extends IdeaFacet {

    Set<File> sourceRoots = [] as Set
    Set<IdeaDeploymentDescriptor> descriptors = [] as Set
    Set<IdeaWebRoot> webroots = [] as Set

    IdeaWebFacet() {
        super('web');
    }

    @Override
    protected Facet createFacet(PathFactory pathFactory) {
        WebFacet facet = new WebFacet();
        def path = { pathFactory.path(it) }
        facet.sourceRoots = getSourceRoots().findAll { it.exists() }.collect { path(it) }
        facet.descriptors = getDescriptors().findAll { it.file.exists() }.collect { new DeploymentDescriptor(path(it.file), it.name) }
        facet.webroots = getWebroots().findAll { it.dir.exists() }.collect { new WebRoot(path(it.dir), it.relative) }
        return facet
    }

    public void descriptor(File file, String name) {
        descriptors.add(new IdeaDeploymentDescriptor(file, name))
    }

    public void webroot(File file, String name) {
        webroots.add(new IdeaWebRoot(file, name))
    }
}
