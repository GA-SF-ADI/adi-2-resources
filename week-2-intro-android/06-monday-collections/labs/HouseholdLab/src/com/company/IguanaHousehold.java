package com.company;




 public class IguanaHousehold extends Household {

 public IguanaHousehold() {
 super(new Iguana());
 }

 @Override
 public void earnMoney() {
  System.out.println("We are the iguana family!");
  System.out.println("**************************");
 System.out.println("How we earn money: Take Iggy Iguana to reptile exhibition");
 this.earnings += 30; //the museum pays us to show people the iguana.  $30 each time!
  System.out.println("We harvest our own crickets and sold a few of them to the neighbor's lizard");
  this.earnings +=5;
 }

 @Override
 public void garden() {
 System.out.println("how we garden: we gardened ourselves and saved money because we did not have to hire someone to mow the lawn");
  this.earnings += 30;
 }

 }
