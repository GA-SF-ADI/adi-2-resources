public class CheckParens{
    public static boolean checkParens(String str){
        Stack<Character> parenStack = new Stack<>();
        ArrayList<Character> endParens = new ArrayList<>();

        endParens.add('}');
        endParens.add(']');
        endParens.add(')');
        ArrayList<Character> startParens = new ArrayList<>();
        startParens.add('{');
        startParens.add('[');
        startParens.add('(');
        for(int i = 0; i<str.length(); i++){
            char curChar = str.charAt(i);
            if(endParens.contains(curChar)){
                if(parenStack.isEmpty()){
                    return false;
                }else if(endParens.indexOf(curChar) != startParens.indexOf(parenStack.pop())){
                    return false;
                }
            }else if (startParens.contains(curChar)){
                parenStack.push(curChar);
            }
        }
        return parenStack.isEmpty();
    }

}