package strust.hastable;

public class StudentInfo {
	int age;
	int data;
	
	/*
	 *����Ӧ������ڹ�ϣ���е�λ�ã����ֱ������������Ϊ�±꣬���ַ�����Ϊֱ�Ӷ�ַ��
	 *ȡ�෨����һ�����ݽ���ȡ�࣬��������Ϊ�±꣬���ַ������Լ�Ϊ���Ľ����ݶ������ڹ�ϣ���ĳ��λ���ϣ�
	 *		����Ҫ�����ݼ����ڹ�ϣ���0~9��λ�ã�ֻҪ������%10����
	 *���ݷ��������ҳ����ݵĶ��صġ������ظ��ĵط���������صĵط���Ϊ�±꣬�������֤�ĺ���λ��
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
