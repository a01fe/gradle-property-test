package test.plugin

import groovy.transform.CompileStatic
import org.gradle.api.Project
import org.gradle.api.provider.Property

@CompileStatic
class Foo {

    final Property<String> thing1

    Foo(Project project) {
        thing1 = project.objects.property(String)
    }
}
