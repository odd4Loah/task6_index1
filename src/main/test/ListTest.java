import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * #Title: ListTest
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-18:29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ListTest {

    @Autowired
    StudentListService studentListService;

    @Test
    public void ById() {
        System.out.println("kaishi");
        StudentList a = studentListService.selectByPrimaryKey(52L);
        String ccc =  a.getUsername();
        System.out.println(ccc);

    }
}
