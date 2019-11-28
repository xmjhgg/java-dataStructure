package strust.hastable;

public class StudentInfo {
	int age;
	int data;
	
	/*
	 *返回应当存放在哈希表中的位置，这而直接用年龄来作为下标，这种方法称为直接定址法
	 *取余法：对一个数据进行取余，将余数作为下标，这种方法可以极为简便的将数据都集中在哈希表的某个位置上，
	 *		比如要将数据集中在哈希表的0~9的位置，只要对年龄%10即可
	 *数据分析法：找出数据的独特的、很少重复的地方，将这独特的地方作为下标，比如身份证的后四位。
	 */
	public int hasCode(){
		return age;
	}

	protected StudentInfo(int age, int data) {
		super();
		this.age = age;
		this.data = data;
	}

	protected StudentInfo(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentInfo [age=" + age + ", data=" + data + "]";
	}
	
	
}
