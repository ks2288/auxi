# Overview

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
The following native types are included in functions that reflect either to 
or from both signed and unsigned bytes/arrays:
- `Boolean`
- `BooleanArray`
- `Int`
- `IntArray`
- `Array<Int>`
- `ByteArray`
- `UByteArray`

`String` reflector extensions are included to go to the 
following types:
- `Date`
- `LocalDateTime`

# Usage

This library is able to be used as a dependency within your JVM-based 
project in two ways: through`jitpack.io` as a build dependency or, if you don't 
want to/can't modify your build script for whatever reason, as a submodule 
within your own repo.

### Gradle

#### Groovy
In your `build.gradle` (or other file as needed per your project requirements, 
i.e. `settings.gradle`), add the following `maven` closure to the`repositories` 
closure:
```
maven { 
    url 'https://jitpack.io'
    content { includeGroup "com.github.ks2288" } 
}
```

Then, add the following to your `dependencies` closure:
```
implementation 'com.github.ks2288:auxi:1.0'
```

#### Kotlin
In your `build.gradle.kts` (or other file as needed per your project 
requirements, i.e. `settings.gradle.kts`), add the following `maven` closure 
to the `repositories`closure:
```
maven("https://jitpack.io") {
    content { includeGroup("com.github.ks2288") }
}
```
Then, add the following to your existing `dependencies` closure:
```
 implementation("com.github.ks2288:auxi:1.0")
```

### Submodule (`Git`) 
To use this code directly within your own project and gain the ability 
to edit/add to it as you please (or just use it as a base of your own to add 
to a different upstream at some point), simply execute the following `git` 
command from your machine's CLI:
```
git submodule add https://github.com/ks2288/auxi.git
```

## One Other Quick Note:

As of version 1.0, I don't recommend using the `Logger` until further notice 
for anything other than saving files of full of provided text, which it will do. 
The parameters were fashioned for Java's `ProcessBuilder` and artifacts created 
from its output, so I doubt it will directly satisfy any other needs.

That logger was/is meant to stand in as something similar to `Timber`, but it 
remains a WIP from another project, and will likely exist as its own library at 
some point in the near future. However, feel free to use it as a shell for your 
own logger module. 

That said, it will show you what you need to see as it exists if you really 
want to use it as a `println("...")` replacement, but you'd still be typing 
more characters-worth of text by using the `Logger` outright without direct 
method imports :) It has a few uses within this library, but like I said: 
it's just doing `println()`.