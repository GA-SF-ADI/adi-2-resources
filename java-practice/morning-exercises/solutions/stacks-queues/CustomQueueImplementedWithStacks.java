import java.util.Queue;
import java.util.Stack;

/**
 * Created by hollis on 6/21/16.
 */
public class CustomQueueWithStacks<T> {
    private Stack<T> storageStack;
    private Stack<T> outputStack;

    public void add(T value){
        storageStack.push(value);
    }


    public T remove(){
        if(outputStack.size() == 0){
            if(storageStack.size()==0){
                throw new ArrayIndexOutOfBoundsException();
            }else{
                for(int i = 0; i < storageStack.size(); i++){
                    outputStack.push(storageStack.pop());
                }
            }
        }
        T result = outputStack.pop();
        return result;
    }

}
