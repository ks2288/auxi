# Overview [![](https://jitpack.io/v/ks2288/auxi.svg)](https://jitpack.io/#ks2288/auxi)

### Description

Auxi (short for "auxiliatores" which is Latin for "helpers") is a simple 
collection of Kotlin extension functions for working with various native 
object types within JVM-based applications.

It started as a collection of helpers that made working with hex/byte values 
quicker for inter-process data comms, but it will expand in time to cover 
more classes/types.

Feel free to use at your discretion, or fork it, or just use some of the code 
in your own repo. Or, if you're feeling collaborative, suggest additions :)

### Functionality

#### Extensions

The following native types are included in extension functions that reflect 
either to or from both signed and unsigned (u)bytes/arrays:
- `Boolean`
- `BooleanArray`
- `Int`
- `IntArray`
- `Array<Int>`
- `ByteArray`
- `UByteArray`

`String` reflector extensions are included that reflect the following types:
- `Date`
- `LocalDateTime`

#### File System I/O

The following functionalities are wrapped by the `FSHelper` utility object, 
with error handling:
- Path/directory creation (in "crawl-through" fashion, similar to Java's 
  `File.mkdirs()`)
- Blank `File` creation, with the ability to designate a size in bytes
- Zip `File` creation
- Recursive `File` copying from one directory to another
- Retrieving the raw text contents of a `File` object

# Usage

This library is able to be used as a JVM library in two ways: through 
[Jitpack](https://jitpack.io) as a traditional external library or, if you 
don't want to/can't modify your build script for whatever reason, as a submodule 
within your own Git repo.

### Gradle

#### Groovy
In your `settings.gradle`, add to your existing closure OR define a new 
dependency management resolution closure to match the following:
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' } // this is the new maven addition
    }
}
```

***NOTE: the `dependencyResolutionManagement` closure is not scoped the main 
`build.gradle` file, and it will not be available there under otherwise 
"normal" circumstances while a `settings.gradle` file is present***

Then, add the following to your `dependencies` closure within your 
`build.gradle` file:
```
implementation 'com.github.ks2288:auxi:1.1.0'
```

#### Kotlin
The syntax for Kotlin DSL is mostly identical, with the only difference 
existing in the format of the Maven repo definition function that matches Kotlin 
styling (`URL` function parameter) as opposed to that seen with Groovy (`URL` 
built inside closure with Groovy-style assignment syntax). Within your 
`settings.gradle.kts` file, match the existing repo definitions with the 
following resolution closure:
```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven("https://jitpack.io") // new maven addition; note the difference
    }
}
```
Then, add the following to your existing `dependencies` closure within your 
`build.gradle.kts` file:
```
 implementation("com.github.ks2288:auxi:1.1.0")
```

 #### Maven

To use this library within a Maven-based project, add the following to your 
Maven build file
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Then add the dependency in the same manner:

```
<dependency>
    <groupId>com.github.ks2288</groupId>
    <artifactId>auxi</artifactId>
    <version>Tag</version>
</dependency>
```

### Submodule (`Git`) 
To use this code directly within your own project and gain the ability 
to edit/add to it as you please (or just use it as a base of your own to add 
to a different upstream at some point), simply execute the following `git` 
command from your machine's CLI within the root directory of the local repo:
```
git submodule add https://github.com/ks2288/auxi.git
```