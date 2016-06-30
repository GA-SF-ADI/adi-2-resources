/**
 * Created by hollis on 6/20/16.
 */
public class SuperOld implements IOperateTV {
    boolean power;
    int volume;
    int channel;

    @Override
    public void togglePower(boolean toggle) {
        power = toggle;
    }

    @Override
    public void changeVolume(boolean increase) {
        if(increase){
            volume ++;
        }else{
            volume--;
        }
    }

    @Override
    public void changeChangel(boolean increase) {
            if(increase){
                channel ++;
            }else{
                channel --;
            }
    }
}
