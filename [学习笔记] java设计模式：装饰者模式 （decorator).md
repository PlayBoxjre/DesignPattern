# 装饰者模式 （decorator)

- ## 目录
    - ### 1. 什么是装饰者模式
    - ### 2. 装饰者模式的具体实现
    - ### 3. 装饰者模式的总结

---

- ##  1. 什么是装饰者模式
    - ### Decorator模式简介
         Decorator模式又名包装器(Wrapper)，==动态的将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案==。
        
        - 装饰者和被装饰者对象有相同的超类型
        - 可以使用多个装饰者装饰一个对象
        - 既然装饰者和被装饰者拥有相同的超类型，所以在任何需要原始对象（被包装的）的场合，可以用装饰过的对象代替她。
        - ==装饰者可以在所委托被装饰者的行为之前与/或之后，加上自己的行为，以达到特定的目的。==
        - 对象可以在任何时候被装饰，所以可以在运行时动态的，不限量的用你喜欢的装饰者来装饰对象。

- ## 2.装饰者模式的具体实现
    - ### 装饰者模式的类图
    ![这里写图片描述](http://img.blog.csdn.net/20170112235635942?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvazMxNjM3ODA4NQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
    
    这有一个栗子：
    >我有一间房子，四面墙，一扇窗，一扇门，一屋顶。我想要装修以下我的房子，1.给四面墙贴上蓝色墙纸，将窗户安上毛玻璃。在门上安上一把智能锁，将屋顶换上琉璃瓦。
    
    上面的栗子中什么是被装饰者，谁是装饰者？

    >我开始认为房子是被装饰者，因为我们需要装修，所以按照想法应该是某个东西装饰房子。可是你找不到是什么去装饰房子。后面的东西都和房子不存在装饰关系，只存在组合关系。即房子是由后面组合而成的。但是真正存在装饰关系的是蓝色墙纸装饰墙，磨玻璃装饰窗户，智能锁装饰门，琉璃瓦装饰屋顶。所以我们在这里明确了一点，==如果一个类和另一个类存在装饰关系（包裹），可以从这方面思考，**B 可不可以 在A 的基础上给A加入新的功能**==
    
    所以这里就需要一个定义几个类实现了。
    
    ### Main.java
    ```
        //Wall:墙类
        //BlueWallPaper:蓝色墙纸
        //Display:接口类，用于显示\
        
        package com.playboxjre.decorator;

        /**
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
        
    ```
    ### Display.java
    ```
    package com.playboxjre.decorator;

    public interface Display {
    	void show();
    }
    ```
    ### Wall.java
    ```
        package com.playboxjre.decorator;

        public class Wall implements Display{
        	
        	@Override
        	public void show() {
        		// TODO Auto-generated method stub
        		System.out.println("白色的墙");
        	}
        
        }

    ```
    ### BlueWallPaper.java
    ```
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
    ```
    
- ### 装饰者的总结
    
    >装饰者其实就是给某个类提供扩展支持的。也就是为了增强某一个类的功能，不必修改原有的代码。符合ocp（open-close 开闭原则).如果不用装饰者模式的话，增强一个类的功能可以采取的方式：

    - 1 . 重写新类，在原有代码基础上添加修改。
    - 2 . 使用继承，在现有代码上进行添加修改。如果有新功能的增加，又会获取一个子类，如果需要几个功能，就需要一层一层的继承。类不支持多继承机制。所以照成代码的重复编写。并且继承会产生类一旦被加载，就无法动态修改。
    
    继承：子类复用基类的实现，那么我们不能够去动态的改变所复用的方法，因为在类加载的时候，父类定义的方法固定了。
    
    组合：组合通过共同接口实现的持有者进行复用，因为持有关系是可以动态传入的，所以我们可以根据不同的需求来添加进不同的对象，完成同样的方法的不同实现。所以是动态的
    