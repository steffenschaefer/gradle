package org.gradle.plugins.ide.idea.model

/**
 *
 */
abstract class Facet {

    String name
    String type
    boolean unique

    void store(Node node) {
        def configurationNodes = node.configuration
        Node configurationNode = configurationNodes.isEmpty() ? node.appendNode('configuration') : configurationNodes[0]
        storeConfiguration configurationNode
    }

    abstract void storeConfiguration(Node configurationNode);
}
