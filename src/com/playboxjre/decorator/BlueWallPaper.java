package com.playboxjre.decorator;

public class BlueWallPaper implements Display {
	
	 private Display wall;
	 public BlueWallPaper(Display wall){
		 this.wall = wall;
	 }
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print("蓝色的墙纸贴在了==");
		wall.show();
		
		System.out.println("==现在的墙是蓝色的墙");
	}

}
