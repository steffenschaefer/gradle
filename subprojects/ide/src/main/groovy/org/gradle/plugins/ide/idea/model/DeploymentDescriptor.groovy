package org.gradle.plugins.ide.idea.model

/**
 *
 */
class DeploymentDescriptor {
    Path path
    String name

    DeploymentDescriptor(Path path, String name) {
        this.path = path
        this.name = name
    }
}
