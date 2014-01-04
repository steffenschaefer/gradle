package org.gradle.plugins.ide.idea.model

/**
 *
 */
class WebFacet extends Facet {

    Set<Path> sourceRoots = [] as Set
    Set<DeploymentDescriptor> descriptors = [] as Set
    Set<WebRoot> webroots = [] as Set

    void storeConfiguration(Node node) {
        node.children().clear();

        Node descriptorsNode = node.appendNode('descriptors')
        descriptors.each {
            descriptorsNode.appendNode('deploymentDescriptor', [name: it.name, url: it.path.url])
        }

        Node webrootsNode = node.appendNode('webroots')
        webroots.each {
            webrootsNode.appendNode('root', [url: it.path.url, relative: '/'])
        }

        Node sourceRootsNode = node.appendNode('sourceRoots')
        sourceRoots.each {
            sourceRootsNode.appendNode('root', [url: it.url])
        }
    }
}
