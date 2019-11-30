package com.stationary.data;

public final class API {

	public static enum STATUS{
		SUCCESS(1), ERROR(2) ;
		public int value;
		private STATUS(int key){
			this.value = key;
		}
	}
}