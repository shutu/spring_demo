#Spring @Configuable CTW injecting Demo

## Introduction

@Configurable annotation. This annotation connected with aspects will configure each annotated object even if we will create it outside of the container using new operator. Like with any other aspects we can choose between

* load-time-waving (LTW)
* compile-time-waving (CTW). 

This demo uses CTW.

## Reference

* Injecting Spring beans into non-managed objects, http://www.kubrynski.com/2013/09/injecting-spring-dependencies-into-non.html
* Hedgehog is a Spring, Guice and Weld CDI bean injector in non-managed business java classes., https://danjee.github.io/hedgehog/

