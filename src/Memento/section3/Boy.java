package Memento.section3;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Boy {
	
	//�к���״̬
	private String state = "";
	
	//�κ�Ů���Ӻ�״̬�϶��ı䣬�������顢���еĻ���ȵ�
	public void changeState(){
		this.state = "������ܺܲ���";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//����һ������
	public Memento createMemento(){
		return new Memento(this.state);
	}
	
	//�ָ�һ������
	public void restoreMemento(Memento _memento){
		this.setState(_memento.getState());
	}
}
