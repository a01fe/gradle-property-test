# gradle-property-test

A Gradle project to explore how to get properties in container extensions working.

I'm trying to create a plugin that creates an extension with a nested container.
Plugin consumers should be able to write something like this in `build.groovy`:

```Groovy
foo {
  thing1 = "This is thing1 in foo"
  bars {
    bar1 {
      thing2 = "This is thing2 in foo.bars.bar1"
    }
  }
}
```

`thing1` and `thing2` are `Property<String>`. In the `build.groovy` snippet above, the `foo.thing1` assignment works as expected but assignments to properties in containers fail with:

```plain text
Cannot cast object 'This is thing2 in bar1' with class 'java.lang.String' to class 'org.gradle.api.provider.Property'
```

To demonstrate, run:

```bash
./gradlew test
```
