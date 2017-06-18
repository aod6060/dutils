package com.derf.utils.util;

public class DGenericBean2<S, T> {
	
	private S value1 = null;
	private T value2 = null;
	
	public DGenericBean2() {}
	
	public DGenericBean2(S value1, T value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public S getValue1() {
		return value1;
	}
	
	public void setValue1(S value1) {
		this.value1 = value1;
	}
	
	public T getValue2() {
		return value2;
	}
	
	public void setValue2(T value2) {
		this.value2 = value2;
	}
	
	
}
