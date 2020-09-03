package data;

import com.company.Infrastructure.data.FileUserMapper;

import com.company.Infrastructure.data.User;
import com.company.Infrastructure.data.UserNotFoundException;
import java.io.File.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FileUserMapperTests {


    @Test(expected = UserNotFoundException.class)
    public void findByEmailFileEmptyFile() throws IOException {
        String path = "./src/test.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileUserMapper fileUserMapper = new FileUserMapper(path);
        file.delete();
        fileUserMapper.findByEmail("some_eamail@g.com");
    }

    @Test(expected = UserNotFoundException.class)
    public void findByUsernameFileEmptyFile() throws IOException {
        String path = "./src/test.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileUserMapper fileUserMapper = new FileUserMapper(path);
        file.delete();
        fileUserMapper.findByUsername("username");
    }

    @Test
    public void findByEmailFile() throws IOException {
        String path = "./src/test.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("username,email@g.com,123");
        pw.close();
        FileUserMapper fileUserMapper = new FileUserMapper(path);
        file.delete();
        Assert.assertNotNull(fileUserMapper.findByEmail("email@g.com"));
    }

    @Test
    public void findByUsernameFile() throws IOException{
        String path = "./src/test.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("username,email@g.com,123");
        pw.close();
        FileUserMapper fileUserMapper = new FileUserMapper(path);
        file.delete();
        Assert.assertNotNull(fileUserMapper.findByUsername("username"));

    }


    @Test
    public void checkAllUsersList() throws IOException {
        String path = "./src/test.txt";
        File file = new File(path);
        if (!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("username,email@g.com,123");
        pw.close();
        FileUserMapper fileUserMapper = new FileUserMapper(path);
        file.delete();
        Assert.assertEquals("The list size is not empty ", false, fileUserMapper.getAll().isEmpty());
    }




}
