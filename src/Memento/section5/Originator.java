package Memento.section5;


/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Originator implements Cloneable{
	
	//�ڲ�״̬
	private String state = "";
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//����һ������¼
	public Originator createMemento(){
		return this.clone();
	}
	
	//�ָ�һ������¼
	public void restoreMemento(Originator _originator){
		this.setState(_originator.getState());
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
