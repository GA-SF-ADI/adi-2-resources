---
title: OOP inheritance and abstraction
duration: "1:30"
creator:
    name: Josh Bartz
    city: Missoula

---


# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) OOP inheritance and abstraction

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain how inheritance is used in abstraction
- Explain the difference between an abstract class and an interface
- Use Polymorphism

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Create and inherit from parent classes

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Gather materials needed for class
- Complete Prep work required
- Prepare any specific instructions

---
<a name="opening"></a>
## Opening (5 mins)

You have already seen how inheritance in object-oriented programming allows you to use attributes of parent classes in their children throughout this course while working with Android, but we haven't gone into great detail about how all of these objects really fit together.


<a name="introduction"></a>
## Introduction: Abstraction (10 mins)

The dictionary definition of abstraction is "the act of considering something as a general quality or characteristic, apart from concrete realities, specific objects, or actual instances."

In computer science, abstraction is a method of hiding implementation details from users, leaving them only the functionality. In Java, this is accomplished in two ways: abstract classes and interfaces.

#### Abstract classes

In Java, an abstract class is declared like a normal class, except the `abstract` keyword is also used.

``` java
public abstract class Vehicle {
  ...
}
```


However, an abstract class cannot be instantiated the same as a normal class.

``` java
Vehicle mVehicle = new Vehicle();
```

This line would produce a compiler error. This is because abstract classes are strictly meant to be inherited from, or extended. Basically, an abstract class is meant to create subclasses that share some sort of behavior but may need to execute certain points differently.


Abstract classes structure this behavior using abstract methods, which are also declared using the `abstract` keyword:

``` java
public abstract void start();
public abstract void stop();
```

Notice how these methods do not contain a method body, only a signature. That is because these methods must be overridden in any subclasses of the abstract parent class, or else the subclass must also be declared abstract.

Abstract classes can also contain regular methods and variables, usually containing functionality that will be common for all subclasses.


<a name="demo"></a>
## Demo: Subclassing an Abstract Class (10 mins)

Let's go back to our __Vehicle__ example:

```java
public abstract class Vehicle {

	public abstract void start();

	public void navigate() {
		System.out.println("Turn Left");
		System.out.println("Turn Right");
		System.out.println("Turn Right Again");
	}

	abstract void stop();
}

 /// ... in another code file but same package

public class Car extends Vehicle {

	@Override
	public void start() {
		System.out.println("Turn Key");
		System.out.println("Put Car into Drive");
		System.out.println("Press on Gas Pedal");
	}

	@Override
	public void stop() {
		System.out.println("Press on Brake");
		System.out.println("Put Car in Park");
		System.out.println("Turn Key");
	}

    private void honkHorn() {
        System.out.println("Honk!");
    }
}
```

Notice the different implementations of the __start__ and __stop__ methods. In __Vehicle__, they are declared abstract and have no method body. The implementations in the __Car__ subclass, on the other hand, have method bodies that actually perform some function.


Also note the `Override` annotation. This is to let the compiler know that this method is overriding a parent method, allowing it to check for the proper signature. If you tried to use this method signature in __Car__:

```java
    @Override
    public void stop(String str) {
        //stuff
    }
```

...your IDE will give you a method signature error.


<a name="guided-practice"></a>
## Guided Practice: Identifying errors (10 mins)

Take two minutes to read over the code below.  Let's discuss what errors exist and how they should be fixed:

``` java
public abstract class Company {

	private Employee employee;

	public abstract void hireEmployee() {
		this.employee = new Employee();
	}

	public abstract Product manufactureProduct();

	public abstract void sellProducts();

	public void doBusiness() {
		hireEmployee();
		manufactureProduct();
		sellProducts();
	}
}

// and the child class...

public class ElectronicsCompany extends Company {
	@Override
	public Product manufactureProduct() {
		return new Product(double price);
	}

	@Override
	public double sellProducts() {
		return product.getPrice();
	}
}
```

So, the `hireEmployee` shouldn't be abstract and method declarations for `sellProducts` don't match!


## Introduction: Polymorphism (5 mins)


So why create parent and subclasses, other than saving ourselves the trouble of duplicating code? Copying and pasting between files is easy. What good do parent and subclass relationships actually do?


One way to answer these questions is to demonstrate the power of polymorphism.


``` java
public class Animal {
  public String makeNoise() {
    return "Generic Noise";
  }
}

public class Dog extends Animal {
    @Override
    public String makeNoise() {
        return "Woof";
    }
}
public class Cat extends Animal {
    @Override
    public String makeNoise() {
        return "Meow";
    }
}
```

Why is the above code useful? Let's see how it is used:

```java
//main method of driver class
public static void main(String[] args) {
    Animal[] animals = new Animal[3];
    animals[0] = new Animal();
    animals[1] = new Dog();
    animals[2] = new Cat();

    for(int i = 0; i < animals.length; i++) {
        System.out.println(animals[i].makeNoise());
    }
}
```

The output for this block of code would be:\
`Generic Noise`\
`Woof`\
`Meow`



<a name="guided-practice"></a>

## Independent Practice: Using Polymorphism (15 mins)

Using the starter code in `Employee.java`, create 3 subclasses that override the abstract methods. Have each subclass implement the abstract methods. Then, create a list or array containing one of each type of employee. Using a single `for` loop, have each employee carry out their primary and secondary responsibilities. Then, pay them.


## Introduction: Interfaces (10 mins)

As stated before, abstraction is a method of hiding implementation details from users, leaving them only the functionality. Abstract classes are used in Java to achieve partial abstraction. For full abstraction, interfaces are used.

Like abstract classes, interfaces help to define the behavior of a class. Interfaces cannot be instantiated, and use abstract methods that must be overridden in classes that implement them. In order to __implement__ an interface, all of its abstract methods must be overridden.

#### Implementing Interfaces

Let's start with a quick look at a commonly implemented interface: `Comparable<T>`

``` java
public class Person implements Comparable<Person> {
    private int age;
    public Person(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public int compareTo(Person other) {
        int result = 0;
        if(this.age < other.getAge()) {
            result = -1;
        } else if(this.age > other.getAge()) {
            result = 1;        
        }
        return result;
    }
}
```

When using `Comparable`, an integer is always returned from the `compareTo(...)` method. If the integer is less than 0, the object calling `compareTo` is less than the object passed as the argument (__other__ in the example above). If the integer is greater than 0, the object is greater than the other. If the integer equals 0, then the objects are equal.


The `Comparable` interface is useful for sorting. For example, in order to use `Collections.sort(...)` or `Arrays.sort(...)` on your custom objects, you must implement `Comparable`.

```java
public static void main(String[] args) {
    Person[] people = new Person[3];
    //remember that the constructor of Person takes the age as an argument
    people[0] = new Person(10);
    people[1] = new Person(13);
    people[2] = new Person(5);

    for(int i = 0; i < people.length; i++) {
        System.out.println("Age: " + people[i].getAge());
    }
    //Output of this block:
    //Age: 10
    //Age: 13
    //Age: 5

    Arrays.sort(people);

    for(int i = 0; i < people.length; i++) {
        System.out.println("Age: " + people[i].getAge());
    }

    //Output of this block:
    //Age: 5
    //Age: 10
    //Age: 13
}
```

<a name="demo"></a>
## Demo: Define Behavior using an Interface (10 mins)

Let's say you wanted to write a program that could do basic operations on any TV, new or old. Older TVs had a much different interface than newer ones, but their most basic behaviors were the same.



Use an interface!

``` java
public interface IOperateTV {
	void togglePower(boolean on);
	void changeVolume(boolean increase);
	void changeChannel(boolean increase);
}
```


<a name="ind-practice"></a>
## Independent Practice: Implementing an Interface (10 mins)

Create two classes, `SuperNew` and `SuperOld` that implement the `IOperateTV` interface. Then create an object of each class and a List or an Array that contains both objects. Finally, use polymorphism to call a few methods of the objects while iterating through the array or list. The implementation will be similar to what was done with the abstract class sample earlier. For the sake of this exercise, just use print statements to describe the actions of the classes.



<a name="conclusion"></a>
## Conclusion (5 mins)

Abstraction is a very important principle of object-oriented programming. Most Android applications will use interfaces and/or abstract classes in many places and many ways. For this reason, questions regarding abstraction (and polymorphism) frequently are asked in interviews. It is important to know the differences between abstract classes and interfaces, as well as when each should be used. Familiarity with Java standard library interfaces and classes that implement them is also very useful when designing applications.

- Explain the differences between classes and interfaces.
- Identify situations to use one vs. the other.
