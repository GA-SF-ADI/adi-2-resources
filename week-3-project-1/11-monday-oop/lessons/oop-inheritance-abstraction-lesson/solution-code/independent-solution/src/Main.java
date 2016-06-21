public class Main {

    public static void main(String[] args) {
	// write your code here
        Employee[] employees = new Employee[2];
        employees[0] = new Admin();
        employees[1] = new IT();
        ((IOperateTV )employees[0]).togglePower(true);
        for(int i = 0; i < employees.length; i++){
            employees[i].primaryResponsibility();
            employees[i].secondaryResponsibility();
            employees[i].getPaid();

        }

        IOperateTV[] tvs = new IOperateTV[2];
        tvs[0] = new SuperOld();
        tvs[1] = new IT();
        tvs[0].togglePower(true);
        tvs[1].changeChangel(true);
    }
}
