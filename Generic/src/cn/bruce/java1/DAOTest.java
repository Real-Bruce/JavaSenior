package cn.bruce.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java1
 * @create 2020-04-30 10:32
 */
public class DAOTest {
    @Test
    public void test(){
        CustomerDAO dao = new CustomerDAO();
        dao.add(new Customer());
        List<Customer> list = dao.getForList(10);

        StudentsDAO dao2 = new StudentsDAO();
        List<Students> students = dao2.getForList(1);
    }
}
