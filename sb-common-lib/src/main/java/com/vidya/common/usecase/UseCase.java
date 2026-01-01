package com.vidya.common.usecase;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SingletonInitializer
public @interface UseCase {}
