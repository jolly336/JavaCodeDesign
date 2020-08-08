package Memento.section7;

import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class Memento {
	
	//����HashMap��Ϊ״̬
	private HashMap<String,Object> stateMap;
	
	//����һ�����󣬽���һ������
	public Memento(HashMap<String,Object> map){
		this.stateMap = map;
	}

	public HashMap<String,Object> getStateMap() {
		return stateMap;
	}

	public void setStateMap(HashMap<String,Object> stateMap) {
		this.stateMap = stateMap;
	}
	
	
	
}
