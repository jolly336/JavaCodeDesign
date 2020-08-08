package Memento.section8;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Memento {
	
	//�����˵��ڲ�״̬
	private String state = "";
	
	//���캯�����ݲ���
	public Memento(String _state){
		this.state = _state;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
