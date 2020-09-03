package com.company.Infrastructure.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUserMapper implements UserMapper {

    private List<User> allUsers = new ArrayList<>();

    public FileUserMapper(String newPath){
        String path = "./src/users.txt";
        if (newPath != null || newPath != "")
            path = newPath;

        try{
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;

            while ((st = br.readLine()) != null){
                String parts[] = st.split(",");
                allUsers.add(new User(parts[0], parts[1], parts[2]));


            }

        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

    }


    public List<User> getAll(){
        return allUsers;
    }

    //shpould throw userNotFound exception
    @Override
    public User findByEmail(String email) {
        User resultUser = null;
        for(User user:allUsers){
            if(user == null){
                throw new IllegalArgumentException();
            }
            if (user.getEmail().equals(email))
                resultUser = user;
        }
        if (resultUser == null) {
            throw new UserNotFoundException("User with email" + email);
        }
        return resultUser; //exception
    }

    @Override
    public User findByUsername(String userName) {
        User resultUser = null;
        for (User user:allUsers){
            if(user == null){
                throw new IllegalArgumentException();
            }
            if (user.getUserName().equals(userName))
                resultUser = user;
        }
        if (resultUser == null){
            throw new UserNotFoundException("User with userName:" + userName);
        }
        return resultUser;
    }
}
