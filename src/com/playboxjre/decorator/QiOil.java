package com.playboxjre.decorator;

public class QiOil implements Oil{
	private Oil mOil;
	public QiOil(Oil oil){
		this.mOil = oil;
	}
	
	@Override
	public void fire() {
		// TODO Auto-generated method stub
		mOil.fire();
		System.out.println("可以作为发动机的燃料");
	}

}
