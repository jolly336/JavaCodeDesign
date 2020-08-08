package Memento.section4;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {
	
	public static void main(String[] args) {
		//�����������
		Originator originator = new Originator();
		//���������¼����Ա
		Caretaker caretaker = new Caretaker();
		//����һ������¼
		caretaker.setMemento(originator.createMemento());
		//�ָ�һ������¼
		originator.restoreMemento(caretaker.getMemento());
	}
}
