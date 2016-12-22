#Spring @Configuable CTW injecting Demo

## Introduction

@Configurable annotation. This annotation connected with aspects will configure each annotated object even if we will create it outside of the container using new operator. Like with any other aspects we can choose between

* load-time-waving (LTW)
* compile-time-waving (CTW). 

This demo uses CTW.

## HOWTO: Maven, Lombok and AspectJ together

If you’re on this page, you have your purpose, you want to configure the maven pom.xml to enable the usage of lombok and aspectj the same time. The solution is to forbid for the aspectj-maven-plugin to regenerate the class files, because without any configuration the compile-and-weaving process looks that way:

* javac compiles your .java files to .class files with lombok (generating methods, etc.)
* aspectj regenerates your classes from the .java files without lombok

see: https://palesz.wordpress.com/2011/12/03/howto-maven-lombok-and-aspectj-together/

## Reference

* spring @configurable demo: https://github.com/williewheeler/spring-configurable-demo
* Injecting Spring beans into non-managed objects, http://www.kubrynski.com/2013/09/injecting-spring-dependencies-into-non.html
* Hedgehog is a Spring, Guice and Weld CDI bean injector in non-managed business java classes., https://danjee.github.io/hedgehog/
