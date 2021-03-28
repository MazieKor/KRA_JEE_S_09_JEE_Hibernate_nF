package pl.coderslab.spring01.Test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class SimpleSampleTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test1(){
        assertEquals(6, 3+3);
        List<String> testingList = Arrays.asList("tomek", "marek");
        assertEquals("tomek", testingList.get(0));

    }




}
