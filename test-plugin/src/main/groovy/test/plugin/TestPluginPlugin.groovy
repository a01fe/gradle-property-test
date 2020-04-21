package test.plugin

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.plugins.ExtensionAware

public class TestPluginPlugin implements Plugin<Project> {
    public void apply(Project project) {
        ExtensionAware foo = project.extensions.create('foo', Foo, project) as ExtensionAware
        def bars = project.container(Bar) { name -> new Bar(name, project) }
        foo.extensions.add("bars", bars)
        project.tasks.register('test') {
            doLast {
                println "test - foo.thing1 returns \"${project.foo.thing1.get()}\""
                project.foo.bars.each { bar -> println "test - foo.bars.${bar.name}.thing2 returns \"${bar.thing2.get()}\""}
            }
        }
    }
}
