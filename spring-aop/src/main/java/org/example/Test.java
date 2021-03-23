package org.example;

import Proxy.ProxyHelper;

public class Test {
    public static void main(String[] args) {
        IOperation s = ProxyHelper.CreateJDKProxy(new OperationClass());
        s.Do();

        OperationClass2 operationClass2 = ProxyHelper.CreateCglibProxy(new OperationClass2());
        operationClass2.Do();

    }
}
