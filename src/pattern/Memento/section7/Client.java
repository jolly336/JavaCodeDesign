package pattern.Memento.section7;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {
	
	public static void main(String[] args) {
		//�����������
		Originator ori = new Originator();
		//���������¼����Ա
		Caretaker caretaker = new Caretaker();
		//��ʼ��
		ori.setState1("�й�");
		ori.setState2("ǿʢ");
		ori.setState3("����");
		System.out.println("===��ʼ��״̬===\n"+ori);
		//����һ������¼
		caretaker.setMemento(ori.createMemento());
		//�޸�״ֵ̬
		ori.setState1("���");
		ori.setState2("�ܹ�");
		ori.setState3("����");
		System.out.println("\n===�޸ĺ�״̬===\n"+ori);
		//�ָ�һ������¼
		ori.restoreMemento(caretaker.getMemento());
		System.out.println("\n===�ָ���״̬===\n"+ori);
	}
}
