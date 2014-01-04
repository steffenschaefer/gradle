package org.gradle.plugins.ide.idea.model

/**
 *
 */
class WebRoot {
    Path path
    String relative

    WebRoot(Path path, String relative) {
        this.path = path
        this.relative = relative
    }
}
