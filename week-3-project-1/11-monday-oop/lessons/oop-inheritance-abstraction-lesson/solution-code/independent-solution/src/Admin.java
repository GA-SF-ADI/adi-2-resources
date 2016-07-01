/**
 * Created by hollis on 6/20/16.
 */
public class Admin extends Employee {

    public Admin(){
        super(6);
    }
    @Override
    public  void primaryResponsibility(){
        System.out.println("Did Admin stuff");
        char c;
        System.out.println("hours worked at first admin stuff before adding is: " + hoursWorked);
        hoursWorked += 10;
    }
    @Override
    public void secondaryResponsibility(){
        System.out.println("did more Admin stuff");
        hoursWorked += 5;

    }

}
