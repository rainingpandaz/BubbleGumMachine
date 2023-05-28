import java.util.*;
public class DebitCard{
  private double balance;
  private int PIN;
  private boolean locked;
  private static final int VALIDATION = 912345;

  public DebitCard(int pin){
    balance = 50.00;
    PIN = pin;
    locked = false;
  }

  public String toString(){
    String answer = "The balance is $" + balance + ", the pin is " + PIN + ", and whether it is locked is " + locked;
    return answer;
  }

  public double addFunds(double funds){
    balance += funds;
    return balance;
  }

  public boolean withdrawFunds(double amount){
    if(balance >= amount){
      balance -= amount;
      return true;
    }
    else{
      return false;
    }
  }

  public boolean changeSecurity(){
    locked = !locked;
    return locked;
  }

  public int getPin(int code){
    if(code == VALIDATION){
      return PIN;
    }
    else{
      return -1;
    }
  }

  public double getBalance(){
    return balance;
  }

  public boolean getLocked(){
    return locked;
  }

  
  



  
}
