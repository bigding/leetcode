import java.util.LinkedList;
import java.util.List;

public class EmployeeImportance_690 {
    public int getImportance(List<Employee> employees, int id) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(id);
        int imp = 0;
        while(!stack.isEmpty()) {
            int tmpId = stack.removeFirst();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).id == tmpId) {
                    imp += employees.get(i).importance;
                    List<Integer> tmp = employees.get(i).subordinates;
                    for (Integer j : tmp) {
                        stack.addLast(j);
                    }
                }
            }
        }
        return imp;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
