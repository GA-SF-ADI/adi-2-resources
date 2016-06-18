package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class DiamondbackSnake extends Reptile {
        String tongueFlick;

        String rattler;


        public DiamondbackSnake(int numLegs, int topSpeed, boolean isEndangered, String name, int eggs, String scales, String tongueFlick, String rattler) {
            super(numLegs, topSpeed, isEndangered, name, eggs, scales);
            this.tongueFlick = tongueFlick;
            this.rattler = rattler;
        }

        public String getTongueFlick() {
            return tongueFlick;
        }

        public void setTongueFlick(String tongueFlick) {
            this.tongueFlick = tongueFlick;
        }

        public String getRattler() {
            return rattler;
        }

        public void setRattler(String rattler) {
            this.rattler = rattler;
        }
    }