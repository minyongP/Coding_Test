package com.ssafy.ws.step3_1;

/**
 * 다형성 연습하기
 * 
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 * 
 * 다형성은 어느 한 객체가 다양한 형태를 갖을 수 있음을 의미합니다.
 * 
 * 이전 실습의 Person, Student, Teacher를 복사해 옵니다.
 * 
 */
public class PolymorphismTest2 {
	
	public static void main(String[] args) {
		
		// Q. 임의의 Person 객체 2개를 생성합니다.
		____ person1 = new ____();
		____ person2 = new ____();
		
		// Q. Person 데이터를 담을 Person 배열을 생성합니다. (크기는 6)
		____ personList = new ____;
		
		// Q. 0, 1 인덱스에 person 객체를 저장해 봅시다.
		personList[____] = ____;
		personList[____] = ____;
		
		
		
		// Q. 임의의 Student 객체 2개를 생성합니다.
		____ student1 = new ____();
		____ student2 = new ____();
		
		// Q. Student 데이터를 담을 Student 배열을 생성합니다. (크기는 2)
		____ studentList = new ____;
		
		// Q. 각 인덱스에 student 객체를 저장해 봅시다.
		studentList[____] = ____;
		studentList[____] = ____;
		
		
		// Q. 임의의 Teacher 객체 2개를 생성합니다.
		____ teacher1 = new ____();
		____ teacher2 = new ____();
		
		// Q. Student 데이터를 담을 Student 배열을 생성합니다. (크기는 2)
		____ teacherList = new ____;
		
		// Q. 각 인덱스에 student 객체를 저장해 봅시다.
		teacherList[____] = ____;
		teacherList[____] = ____;
		
		
		
		
		// Q. person 배열에 2, 3번 인덱스에는 student 객체를, 4, 5번 인덱스에는 teacher 객체를 저장해봅시다.
		personList[____] = ____;
		personList[____] = ____;
		personList[____] = ____;
		personList[____] = ____;
		
		
		// Q. 반복문을 이용하여 person 배열을 탐색하고, 그 객체의 종류를 출력해 봅시다.
		for(int idx = 0; idx < personList.____; idx++) {
			System.out.print("" + idx + "번 째: ");
			
			if(personList[idx] ____ ____) {
				System.out.println("선생님 입니다.");
			}
			else if(personList[idx] ____ ____) {
				System.out.println("학생 입니다.");
			}
			else if(personList[idx] ____ ____) {
				System.out.println("사람 입니다.");
			}
		}
	}
}
