package pattern.Memento.section7;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class BeanUtils {

	//��bean���������Լ���ֵ���뵽Hashmap��
	public static HashMap<String,Object> backupProp(Object bean){
		HashMap<String,Object> result = new HashMap<String,Object>();
		try {
			//���Bean����
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			//�����������
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			//������������
			for(PropertyDescriptor des:descriptors){
				//��������
				String fieldName = des.getName();
				//��ȡ���Եķ���
				Method getter = des.getReadMethod();
				//��ȡ����ֵ
				Object fieldValue = getter.invoke(bean, new Object[]{});
				if(!fieldName.equalsIgnoreCase("class")){
					result.put(fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			//�쳣����
		}
		return result;
	}
	
	//��HashMap��ֵ���ص�bean��
	public static void restoreProp(Object bean,HashMap<String,Object> propMap){
		try {
			//���Bean����
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			//�����������
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			//������������
			for(PropertyDescriptor des:descriptors){
				//��������
				String fieldName = des.getName();
				//������������
				if(propMap.containsKey(fieldName)){
					//д���Եķ���
					Method setter = des.getWriteMethod();
					setter.invoke(bean, new Object[]{propMap.get(fieldName)});
				}
			}
		} catch (Exception e) {
			//�쳣����
			System.out.println("shit");
			e.printStackTrace();
		}
	}
	
}
