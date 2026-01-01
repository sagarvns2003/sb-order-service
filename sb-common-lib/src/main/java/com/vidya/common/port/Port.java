package com.vidya.common.port;

public interface Port<T, R> {
  R execute(T request);
}
