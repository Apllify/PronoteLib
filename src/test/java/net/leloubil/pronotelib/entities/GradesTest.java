package net.leloubil.pronotelib.entities;

import net.leloubil.pronotelib.PronoteConnection;
import net.leloubil.pronotelib.TestPronotConnection;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class GradesTest {

    @Test
    public void GetGradesTest() throws IllegalAccessException{
	PronoteConnection comm = new PronoteConnection(TestPronotConnection.url);
        assertTrue("connexion",comm.login(TestPronotConnection.user, TestPronotConnection.pass));
        GradeData t = comm.getGrades("Trimestre 1");
	    //checkNull(t);
        System.out.println(t);
    }

    private void checkNull(Object o) throws IllegalAccessException{
	    assertNotNull("EDT pas nul",o);
    	for (Field f : o.getClass().getDeclaredFields()){
		f.setAccessible(true);
        	assertNotNull(f.getName() + " pas nul dans EDT",f.get(o));
	}
    }
}
