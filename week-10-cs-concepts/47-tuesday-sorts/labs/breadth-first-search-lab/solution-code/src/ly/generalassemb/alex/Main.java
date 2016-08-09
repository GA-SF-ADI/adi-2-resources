package ly.generalassemb.alex;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Character seekValue = 'Z';

        Node searchedNode = tree.findValueByBfs(seekValue);
        if (searchedNode == null){
            System.out.println("Could not find value " + seekValue);
        } else {
            System.out.println("Found value " + seekValue);
        }
    }
}
