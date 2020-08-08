package Memento.section9;

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
	public IMemento createMemento(){
		return new Memento(this.state);
	}
	
	//�ָ�һ������¼
	public void restoreMemento(IMemento _memento){
		this.setState(((Memento)_memento).getState());
	}
	
	//������
	private class Memento implements IMemento{
		
		//�����˵��ڲ�״̬
		private String state = "";
		
		//���캯�����ݲ���
		private Memento(String _state){
			this.state = _state;
		}
		
		private String getState() {
			return state;
		}

		private void setState(String state) {
			this.state = state;
		}
		
	}

}
