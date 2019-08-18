package summer.holiday.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 猫狗队列
 * 
 * */
public class queueCatDog {

	public static  class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
			// TODO Auto-generated constructor stub
		}

		public void queueCatDog(String type) {
			this.type = type;

		}

		public String getPointType() {
			return this.type;
		}

	}

	public static class Dog extends Pet {

		public Dog(String type) {
			super(type);
			// TODO Auto-generated constructor stub
		}

	}

	public static class Cat extends Pet {
		public Cat(String type) {
			super(type);
			// TODO Auto-generated constructor stub
		}
	}
	//封装猫狗以及加上一个新属性inde用来确定猫和狗的2入队顺序
	public static class newPet {
		private Pet pet;
		private int index;

		public newPet(Pet pet, int index) {
			this.pet = pet;
			this.index = index;
		}

		public Pet getPet() {
			return pet;
		}

		public void setPet(Pet pet) {
			this.pet = pet;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
		
	}
	
	//猫狗队列的实现
	public static class queuePet {
		private Queue<newPet> dog;
		private Queue<newPet> cat;
		private int index;

		public queuePet() {
			this.dog = new LinkedList<>();
			this.cat = new LinkedList<>();
			this.index = 0;

		}

		public void add(Pet pet) {
			newPet temp = new newPet(pet, index++);
			if (pet.getPointType().equals("dog")) {
				dog.add(temp);
			} else if (pet.getPointType().equals("cat")) {
				cat.add(temp);
			} else {
				System.out.println("no pet");
			}
		}

		public Pet pollAll() {
			if (dog.isEmpty() && cat.isEmpty())
				return null;
			else if (dog.isEmpty())
				return cat.poll().getPet();
			else if (cat.isEmpty())
				return dog.poll().getPet();

			else if (dog.peek().getIndex() < cat.peek().getIndex()) {
				return dog.poll().getPet();
			} else {
				return cat.poll().getPet();
			}

		}

		public Pet pollDog() {
			if (dog.isEmpty())
				return null;
			else
				return dog.poll().getPet();
		}

		public Pet pollCat() {
			if (cat.isEmpty())
				return null;
			else
				return cat.poll().getPet();
		}

		public boolean isEmpty() {
			if (dog.isEmpty() && cat.isEmpty())
				return true;
			return false;

		}

		public boolean isDogEmpty() {
			if (dog.isEmpty())
				return true;
			return false;
		}

		public boolean isCatEmpty() {
			if (cat.isEmpty())
				return true;
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		queuePet demo=new queuePet();
		Pet a=new Pet("dog");
		Pet b=new Dog("cat");
		Pet c=new Dog("dog");
		Pet d=new Dog("dog");
		Pet e=new Dog("dog");
		demo.add(a);
		demo.add(b);
		demo.add(c);
System.out.println(demo.pollCat());
System.out.println(demo.isCatEmpty());
	}

}