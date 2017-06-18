package com.derf.utils.util;

public class DGenericBean4<S, R, T, U> {
	
	private S value1;
	private R value2;
	private T value3;
	private U value4;
	
	public DGenericBean4() {}
	
	public DGenericBean4(S value1, R value2, T value3, U value4) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.value4 = value4;
	}
	
	public S getValue1() {
		return value1;
	}
	
	public void setValue1(S value1) {
		this.value1 = value1;
	}
	
	public R getValue2() {
		return value2;
	}
	
	public void setValue2(R value2) {
		this.value2 = value2;
	}
	
	public T getValue3() {
		return value3;
	}
	
	public void setValue3(T value3) {
		this.value3 = value3;
	}
	
	public U getValue4() {
		return value4;
	}
	
	public void setValue4(U value4) {
		this.value4 = value4;
	}
}
