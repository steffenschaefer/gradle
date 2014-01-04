package org.gradle.plugins.ide.idea.model

/**
 *
 */
class IdeaDeploymentDescriptor {
    File file
    String name

    IdeaDeploymentDescriptor(File file, String name) {
        this.file = file
        this.name = name
    }
}
