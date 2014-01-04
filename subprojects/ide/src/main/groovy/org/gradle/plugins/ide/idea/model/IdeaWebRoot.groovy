package org.gradle.plugins.ide.idea.model

/**
 *
 */
class IdeaWebRoot {
    File dir
    String relative

    IdeaWebRoot(File dir, String relative) {
        this.dir = dir
        this.relative = relative
    }
}
