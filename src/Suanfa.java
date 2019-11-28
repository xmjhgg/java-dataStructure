


public class Suanfa {
	public static void main(String[] args) {
		
//		System.out.println(fbonaqi(10));
		
		hanoi(5, 'A', 'B', 'C');
		
	}
	
	//斐波那契数列：1 1 2 3 5 8 13 21 34 55
	public static int fbonaqi(int i){
		if(i==1||i==2){
			return 1;
		}else{
			return fbonaqi(i-1)+fbonaqi(i-2);
		}
	}
	
	//汉诺塔问题,本方法当盘子达到5时会出错。
	public static void hanoi(int n,char one,char two,char three){
		//只有一个盘子
		if(n==1){
			System.out.println("将(1)从"+one+"移动到"+three);
		}
		//大于一个盘子的情况下
		/*
		 * 不论有多少个盘子，都视为两个盘子，最底下的盘子和最底下的上面的盘子，借助第三者柱子来移动
		 * */
		else{
			//移动上面的盘子到中间的柱子
			hanoi(n-1,one,three,two);
			//移动完上面的就移动最底下的盘子
			System.out.println("将"+n+"从"+one+"移动到"+three);
			//把上面的盘子移动到目标柱子
			hanoi(n-1,two,one,three);
		}
	}
	

}
