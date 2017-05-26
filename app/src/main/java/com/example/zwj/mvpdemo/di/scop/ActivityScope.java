package com.example.zwj.mvpdemo.di.scop;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * <b>创建时间</b> 17/5/26 <br>
 *
 * @author zhouwenjun
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {}