package Memento.section6;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Originator implements Cloneable{
	private Originator backup;
	
	//�ڲ�״̬
	private String state = "";
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//����һ������¼
	public void createMemento(){
		this.backup = this.clone();
	}
	
	//�ָ�һ������¼
	public void restoreMemento(){
		//�ڽ��лָ�ǰӦ�ý��ж��ԣ���ֹ��ָ��
		this.setState(this.backup.getState());
	}
	
	//��¡��ǰ����
	@Override
	protected Originator clone(){
		
		try {
			return (Originator)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
