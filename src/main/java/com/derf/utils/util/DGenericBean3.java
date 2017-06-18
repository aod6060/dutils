package com.derf.utils.util;

public class DGenericBean3<S, R, T> {
	private S value1;
	private R value2;
	private T value3;
	
	
	public DGenericBean3() {}
	
	public DGenericBean3(S value1, R value2, T value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
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
	
}
