package pattern.Memento.section6;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Client {
	
	public static void main(String[] args) {
		//���巢����
		Originator originator = new Originator();
		//������ʼ״̬
		originator.setState("��ʼ״̬...");
		System.out.println("��ʼ״̬�ǣ�"+originator.getState());
		//��������
		originator.createMemento();
		//�޸�״̬
		originator.setState("�޸ĺ��״̬...");
		System.out.println("�޸ĺ�״̬�ǣ�"+originator.getState());
		//�ָ�ԭ��״̬
		originator.restoreMemento();
		System.out.println("�ָ���״̬�ǣ�"+originator.getState());
	}
}
