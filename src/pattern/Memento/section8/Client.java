package pattern.Memento.section8;

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
		//������������¼
		caretaker.setMemento("001",originator.createMemento());
		caretaker.setMemento("002",originator.createMemento());
		//�ָ�һ��ָ����ǵı���¼
		originator.restoreMemento(caretaker.getMemento("001"));
	}
}
