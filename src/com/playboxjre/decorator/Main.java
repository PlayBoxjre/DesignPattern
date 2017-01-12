package com.playboxjre.decorator;

/**
 * <pre>
 * >我有一间房子，四面墙，一扇窗，一扇门，一屋顶。我想要装修以下我的房子，
 * 1.给四面墙贴上蓝色墙纸，将窗户安上毛玻璃。在门上安上一把智能锁，
 * 将屋顶换上琉璃瓦。

 *  >我开始认为房子是被装饰者，
 *  因为我们需要装修，所以按照想法应该是某个东西装饰房子。
 *  可是你找不到是什么去装饰房子。后面的东西都和房子不存在装饰关系
 *  ，只存在组合关系。即房子是由后面组合而成的。
 *  但是真正存在装饰关系的是蓝色墙纸装饰墙，
 *  磨玻璃装饰窗户，
 *  智能锁装饰门，
 *  琉璃瓦装饰屋顶。
 *  所以我们在这里明确了一点，==如果一个类和另一个类存在装饰关系（包裹），
 *  可以从这方面思考，**B 可不可以 在A 的基础上给A加入新的功能**==
 * </pre>
 * 
 * <p>这里我们只实现墙的装饰者模式应用</p>
 * 
 * @author xiangxiang
 *
 */
public class Main {
	public static void main(String[] args) {
		Wall wall = new Wall();
		BlueWallPaper bwp = new BlueWallPaper(wall);
		bwp.show();
		
		
		
	}

}
