package strust.hastable;

import java.util.Arrays;

public class Hastable {
	StudentInfo[] sti=new StudentInfo[100];

	//���
	public void put(StudentInfo info){
		int index=info.hasCode();
		//�����ǰλ����û�д�ֵ����ôֱ�Ӵ�ż���
		if (sti[index]==null) {
			sti[index]=info;
		//����У���ôʹ������̽�ⷨ���ҳ���һ���ܴ��ֵ��λ��
		//����̽�ⷨ�������ǰλ���д��ֵ����ô���ҵ�ǰλ��+1��λ�ã�ֱ���ҵ�Ϊ�յ�λ��
		//
		}else{
			while(sti[index]!=null){
				index++;
			}
			sti[index]=info;
		}
		
	}
	
	
	//��ȡ
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
