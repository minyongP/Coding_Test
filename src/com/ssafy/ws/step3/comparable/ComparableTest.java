package com.ssafy.ws.step3.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 컬렉션 프레임워크 연습하기
 * 
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 * 
 * 컬렉션 프레임워크는 데이터를 쉽고 효과적으로 관리하고 사용할 수 있는 표준화된 방법을 제공하는 기능입니다.
 * 
 * 컬렉션 프레임워크를 이해하기 전에 '다형성'과 '인터페이스'를 반드시 이해후 학습하는 것이 좋습니다. 
 * 
 * 
 * Comparable은 인터페이스로 반드시 구현되어야만 합니다.
 * 비교는 항상 2개의 객체가 비교되어야합니다.
 * Comparable은 클래스 자체가 하나의 비교 대상이며, compareTo() 메소드에 다른 비교 대상을 전달받아 비교하게됩니다.
 * 
 */

// Q. 이름과 키를 저장할 수 있는 Person 객체를 선언하고, Comparable을 구현해 봅시다.
class Person implements Comparable<Person> {
	String name;
	int height;
	
	// Q. 이름과 키를 전달받아 객체를 생성할 수 있도록 파라미터 생성자를 구현해 봅시다.
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}

	// Q. compareTo 메소드를 Override 해 봅시다.
	@Override
	public int compareTo(Person p) {
		
		// Q. 현재 이 클래스와 파라미터로 전달받은 객체간 height를 비교해 봅시다.
		int result = this.height - p.height;
		
		// Q. result 값이 양수인 경우 현재 클래스가 더 크다는 것을 의미합니다.
		//    현재 클래스가 더 크기 때문에 return 1;을 작성합니다.
		if(result > 0) {
			return 1;
		}
		
		// Q. result 값이 음수인 경우 현재 클래스가 더 작다는 것을 의미합니다.
		//    현재 클래스가 더 작기 때문에 return -1;을 작성합니다.
		else if(result < 0) {
			return -1;
		}
		
		// Q. 현재 클래스와 파라미터로 전달받은 객체가 동일한 경우 크기가 같음을 의미합니다.
		//    return 0;을 작성합니다.
		return 0;
	}

	@Override
	public String toString() {
		return "이름: " + name + " / 키: " + height;
	}

}

public class ComparableTest {
	
	public static void main(String[] args) {
		
		// Q. 타입으로 List, 저장할 데이터 타입은 Person, 변수 이름으로 personList, 구현체로 ArrayList를 생성해 봅시다.
		List<Person> personList = new ArrayList<>();
		
		// Q. personList에 아래 정보를 저장해 봅시다.
		//    ("마누엘 노이어", 193)
		//    ("해리 케인", 188)
		//    ("우파메카노", 186)
		//    ("김민재", 190)

		personList.add(new Person("마누엘 노이어", 193));
		personList.add(new Person("해리 케인", 188));
		personList.add(new Person("우파메카노", 186));
		personList.add(new Person("김민재", 190));
		
		// Q. personList에 저장된 데이터를 출력해 봅시다.
		// System.out.println(personList);
		for (Person p : personList) {
			System.out.println(p.toString());
		}

		// Q. Collections.sort 메소드를 이용하여 personList를 정렬해 봅시다.
		Collections.sort(personList);
		
		// Q. 다시 personList에 저장된 데이터를 출력해 봅시다.
		for (Person p : personList) {
			System.out.println(p.toString());
		}
		
		// 생각해보기. 이름 순으로 정렬하는 경우에는 compareTo() 메소드를 어떻게 구현할지 생각해 봅시다.
		//         동명이인이 있다면 또 어떻게 구현할 수 있을지 생각해 봅시다.
		
	}
}
