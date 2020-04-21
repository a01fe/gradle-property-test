package test.plugin

import groovy.transform.CompileStatic
import org.gradle.api.Project
import org.gradle.api.provider.Property

@CompileStatic
class Bar {

    final String name
    final Property<String> thing2

    Bar(String name, Project project) {
        this.name = name
        thing2 = project.objects.property(String)
    }
}
