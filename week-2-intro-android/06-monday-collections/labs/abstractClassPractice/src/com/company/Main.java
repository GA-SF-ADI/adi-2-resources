package com.company;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[1];
        employees[0] = new Admin();
        employees[1] = new IT();
        @Override
        public void primaryResponsibility() {
        }

        public void secondaryResponsibility() {
        }

        for(int i=0; i<employees.length;i++){
            employees[i].primaryResponsibility();
            employees[i].secondaryResponsibility();
            employees[i].getPaid();


            }
            }

        }


//    ArrayList<Employee> employeeList = new ArrayList<>();
//
//        employeeList.add(0, new Admin());
//        employeeList.add(1, new Management());
//        employeeList.add(2, new IT());
//
//
//        for (int i = 0; i <= employeeList.size(); i++) {
//            System.out.println(employeeList.indexOf(i));
//        }
//
//employeeList.get(0).getPaid();
    }
}
