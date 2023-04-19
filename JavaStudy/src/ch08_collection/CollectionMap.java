package ch08_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {

	public static void main(String[] args) {
		//맵(HashMap)의 선언
		// key와 Value의 한쌍인 데이터를 저장
		//HashMap(Key, Value) 키가 왼쪽
		HashMap<Integer,String> strMap = new HashMap<>();
		HashMap<String,String> sttMap = new HashMap<>();
		Map<String, Integer> coinMap = new HashMap<>();
			
		
		// 다형성 이용
		strMap.put(1,"나의 검을");
		strMap.put(2,"받아주겠니?");
		strMap.put(3,"받아라!!");
		
		//순서는 보장하지 않음
		System.out.println(strMap);
		
		//중복된 Key값을 허용하지 않음
		//Key값이 중복되는 경우 기존 Value를 덮어쓴다.
		//Value가 중복되는 경우는 상관 없음
		strMap.put(2, "나의 원수!");
		System.out.println(strMap);
		
		System.out.println("\n========================\n");
		
		// .get(key)
		// key에 대한 value를 리턴
		System.out.println(strMap.get(1) + strMap.get(3) + " " + strMap.get(2));
		
		// Value가 존재하지 않는 Key값 입력 시 NULL을 리턴한다.
		System.out.println(strMap.get(10));
		
		// .size()
		// Map 내 저장된 데이터 수 리턴한다.
		System.out.println(strMap.size());
		
		// .containsKey(값)
		// Map 안에 잇는 키(Key)중에 괄호 안 값이 있다면 true || false
		System.out.println(strMap.containsKey(1));
		System.out.println(strMap.containsKey(5));
		System.out.println("--------------------------\n");
		// .containsValue(값)
		// Map 안에 있는 값(Value) 중에 괄호 안 값이 있다면 true || false
		System.out.println(strMap.containsValue("나의 검을"));
		System.out.println(strMap.containsValue("받아주겠니"));
		System.out.println("--------------------------\n");
		
		// .remove(key)
		// 괄호 안 key값에 대한 데이터 삭제
		System.out.println(strMap);
		strMap.remove(2);
		System.out.println(strMap);
		
		// Map 순회 
		// 1. keySet 이용
		Set<Integer> keySet  = strMap.keySet();
		
		// 향상된 for문으로 set을 순회
		for(int a : keySet) {
			System.out.println("-----------------");
			System.out.println(strMap);
			System.out.println("-----------------");
		}
		System.out.println("\n===============================\n");
		// 2. EntrySet 이용
		// Map 내의 하나하나가 객체(entry) 
		Set<Entry<Integer,String>> entrySet = strMap.entrySet();
		//향상된 for문 사용
		for(Entry<Integer,String> entry	: 	entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("\n===================================\n");
		//	forEac(람다식)
		strMap.forEach((key, value) -> System.out.println(key + ":" + value));

		
	}
}
