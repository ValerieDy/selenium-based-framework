package com.company.Infrastructure.data;

public class MapperApp {
    public static void main(String[] args) {
        FileUserMapper mapper = new FileUserMapper(null);

        System.out.println(mapper.getAll());
        System.out.println(mapper.findByEmail("test4@test.com"));
    }
}
