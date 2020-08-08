package pattern.Memento.section8;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Originator {
	
	//�ڲ�״̬
	private String state = "";
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//����һ������¼
	public Memento createMemento(){
		return new Memento(this.state);
	}
	
	//�ָ�һ������¼
	public void restoreMemento(Memento _memento){
		this.setState(_memento.getState());
	}
}
