package config;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderMy {

    @DataProvider
    public Iterator<Object []> loginData()
    {
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("alisiaagranov@gmail.com").password("212229Alisa").build()});
        list.add(new Object[]{Auth.builder().email("alisiaagranov1@gmail.com").password("212229Alisa").build()});
        list.add(new Object[]{Auth.builder().email("uuuuuu1@gmail.com").password("212229Alisa").build()});



        return list.iterator();
    }

    @DataProvider
    public Iterator<Object []> loginDataCSV() throws IOException {
        List<Object []> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Study\\QA30\\Qa30_Pom_SuperScheduler\\src\\test\\resources\\logindata.csv")));

        String line = reader.readLine();
        while (line!=null)
        {
            String [] split = line.split(",");
            list.add(new Object[]{Auth.builder().email(split[0]).password(split[1]).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
