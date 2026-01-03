package com.vidya.common.port;

public interface Port<T, R> {
  default R execute(T input) {
    return null;
  }
}
