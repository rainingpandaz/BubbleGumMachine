import java.util.*;

public class BubbleGumMachine {
    public static Scanner kbr = new Scanner(System.in);

  private int numGumballs;

  public BubbleGumMachine(){
    numGumballs = 100;
  }
  
  public boolean userKnowsPIN(int x){

        for(int i = 1; i <= 3; i++){ 
          System.out.println("Enter PIN number: ");
          String input = kbr.nextLine();
          if(input.equals(x+""))
            return true;

        }
      return false;
    }

  public boolean hasEnoughMoney(int gumballs, double money){
    if(gumballs * 0.25 <= money){
      return true;
    }
    return false;
  }

  public boolean hasEnoughGumballs(int number){
    if(numGumballs >= number){
      return true;
    }
    else{
      return false;}
  }

   public boolean purchase(int number, DebitCard card){		
    if(card.getLocked() == true){
      return false;
    }
    int pinNumber = card.getPin(912345);
    boolean knowsPin =  userKnowsPIN(pinNumber);
    if(knowsPin == false){
      card.changeSecurity();
      return false;
    }
    if(hasEnoughMoney(number, card.getBalance()) != true){
      return false;
    }
    if(hasEnoughGumballs(number) == true){
      numGumballs -= number;
      card.withdrawFunds(0.25 * number);
      return true;
    }
    else{
      return false;
    }
	} 
  

  public static void main(String[] args) {

  /*  DebitCard card1 = new DebitCard(4567);
    System.out.println(card1);
    card1.addFunds(10.0);
    System.out.println(card1);    
      DebitCard c1 = new DebitCard(5555);
   BubbleGumMachine b1 = new BubbleGumMachine();
   System.out.println(b1.userKnowsPIN(c1.getPin(912345)));
    BubbleGumMachine b2 = new BubbleGumMachine();
    System.out.println(b2.hasEnoughMoney(10, 2.40)); // should print false
    System.out.println(b2.hasEnoughMoney(10, 2.60)); // should print true
    System.out.println("\n");
    BubbleGumMachine b3 = new BubbleGumMachine();
    System.out.println(b3.hasEnoughGumballs(101)); // should print false
    System.out.println(b3.hasEnoughGumballs(99)); // should print true
*/
    DebitCard c2 = new DebitCard(5555);
    c2.changeSecurity();
    BubbleGumMachine b4 = new BubbleGumMachine();
    System.out.println(b4.purchase(50, c2));  // should print false
    c2.changeSecurity();
    System.out.println(b4.purchase(50, c2));
    System.out.println(c2.getLocked());
    DebitCard c3 = new DebitCard(5555);
    System.out.println(b4.purchase(4, c3));
    System.out.println(c3.getBalance());
  }
}
