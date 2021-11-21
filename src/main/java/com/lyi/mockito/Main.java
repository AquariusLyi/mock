package com.lyi.mockito;

public class Main {

    public static void main(String[] args) {
        HttpService realHttpService = new HttpService();
        ExampleService exampleService = new ExampleService();
        exampleService.setHttpService(realHttpService);
        System.out.println( exampleService.hello() );
    }
}
