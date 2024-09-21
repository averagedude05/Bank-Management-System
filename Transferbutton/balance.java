class b
{
   b()
   {
    System.out.println(transactionpg.getUpdateBalance());
   }
   public void addbal(int amount)
   {
      System.out.println(transactionpg.getUpdateBalance()+amount);
   }
}
public class balance {

    public static void main(String[] args) {
       
        b a=new b();
        a.addbal(1500);

       
    }
   
}
