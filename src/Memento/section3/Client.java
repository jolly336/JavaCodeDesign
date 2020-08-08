package Memento.section3;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {

	public static void main(String[] args) {
		//����������
		Boy boy = new Boy();
		//����������¼�Ĺ�����
		Caretaker caretaker = new Caretaker();
		//��ʼ����ǰ״̬
		boy.setState("����ܰ���");
		System.out.println("=====�к����ڵ�״̬======");
		System.out.println(boy.getState());
		//��Ҫ��¼�µ�ǰ״̬ѽ
		caretaker.setMemento(boy.createMemento());
		//�к�ȥ׷Ů����״̬�ı�
		boy.changeState();
		System.out.println("\n=====�к�׷Ů���Ӻ��״̬======");
		System.out.println(boy.getState());
		//׷Ů��ʧ�ܣ��ָ�ԭ״
		boy.restoreMemento(caretaker.getMemento());
		System.out.println("\n=====�к��ָ����״̬======");
		System.out.println(boy.getState());
		
	}
}
