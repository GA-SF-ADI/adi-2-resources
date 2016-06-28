/**
 * Created by hollis on 6/20/16.
 */

public class IT extends Employee  implements IOperateTV{
    boolean power;
    int volume;
    int channel;

    @Override
    public void togglePower(boolean toggle) {
        power = !toggle;
    }

    @Override
    public void changeVolume(boolean increase) {
        if(!increase){
            volume++;
        }
        else{
            volume--;
        }
    }

    @Override
    public void changeChangel(boolean increase) {

    }

    public IT(){
        super(5);
    }
    @Override
    public  void primaryResponsibility(){
        System.out.println("Did IT stuff");
        hoursWorked += 9;
    }
    @Override
    public  void secondaryResponsibility(){
        System.out.println("did more IT stuff");
        hoursWorked += 8;

    }

}

