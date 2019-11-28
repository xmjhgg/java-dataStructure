package strust.hastable;

import java.util.Arrays;

public class Hastable {
	StudentInfo[] sti=new StudentInfo[100];

	//添加
	public void put(StudentInfo info){
		int index=info.hasCode();
		//如果当前位置上没有存值，那么直接存放即可
		if (sti[index]==null) {
			sti[index]=info;
		//如果有，那么使用线性探测法来找出下一个能存放值的位置
		//线性探测法：如果当前位置有存放值，那么就找当前位置+1的位置，直到找到为空的位置
		//
		}else{
			while(sti[index]!=null){
				index++;
			}
			sti[index]=info;
		}
		
	}
	
	
	//获取
	public StudentInfo get(StudentInfo info){
		if (sti[info.hasCode()]!=null) {
			return sti[info.hasCode()];
		}else{
			return null;
		}
	}


	@Override
	public String toString() {
		return "Hastable [sti=" + Arrays.toString(sti) + "]";
	}
	
	
}
