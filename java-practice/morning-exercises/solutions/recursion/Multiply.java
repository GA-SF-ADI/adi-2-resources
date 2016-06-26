public class Multiply{
    public int multiplyWithRecursion(int x, int y){
        //BASE CASE
        if(y==0){
            return 0;
        }else{ //RECURSIVE STEP
            return x + multiplyWithRecursion(x, y-1);
        }
    }
}