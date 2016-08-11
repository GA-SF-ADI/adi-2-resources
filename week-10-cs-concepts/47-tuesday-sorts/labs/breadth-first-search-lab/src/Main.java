/**
 * Created by patrickcummins on 8/10/16.
 */
public class Main {
    public static void main(String[] args){
        Tree mTree = new Tree();
        boolean doesZExist = mTree.findValueByDfsRecursively('Z');
        System.out.println(doesZExist);
    }
}
