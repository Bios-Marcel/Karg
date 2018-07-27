# Karg

![Travis Build for branch master](https://travis-ci.org/Bios-Marcel/Karg.svg?branch=master)

## What is this?

`Karg` is supposed to be a library for command line arguments, that works for both kotlin-native and kotlin-jvm.
My goal is to not use any code specific to only kotlin-native or kotlin-jvm.

## Why though?

It's just something i felt like trying, I'll still try to do everything in a serious manner, so this will actually be useful (I hope).

## How do i use this in my project?

You can't, at least not yet.

## How do I build it myself?

You can't, at least not yet.

## How do the unit tests work?

First fo all, the way unit tests are written may change at any commit, as this is mainly an experiment.

Currently all classes containg tests must extend `com.msc.karg.Test`. The functions that actually run
the assert statements aren't annotated like you'd be used to in JUnit for example. Instead they are
registered in `registerTestFunctions`.

A failure won't abort execution of a `TestSuite`, instead it will run all `Test`s an tell you how many
of them ran successfully or have failed.

Here is an example:

```Kotlin
fun main(arguments: Array<String>) {
    TestSuite(listOf(
        ExampleTest()
    )).run()
}

class ExampleTest : Test {
    override fun registerTestFunctions() {
        registerTestFunction(this::testExample)    
    }

    fun testExample() {
        val hello = "Hello"
        val world = "World"
        assertEquals("Hello World", "$hello $world", "Example test title")
    }
}
```

The output of running those would be:

```
-----------------------------------------------------
Tests failed:     0
Tests successful: 1
-----------------------------------------------------
```