/* Copyright (c) 2000-2003, jMock.org. See LICENSE.txt */
package test.jmock.dynamic.testsupport;

import org.jmock.dynamic.DynamicMock;
import org.jmock.dynamic.Invokable;
import org.jmock.dynamic.Stub;
import org.jmock.expectation.AssertMo;
import org.jmock.expectation.ExpectationCounter;
import org.jmock.expectation.ExpectationValue;
import org.jmock.util.Verifier;

import java.lang.reflect.Method;

public class MockDynamicMock
        extends AssertMo
        implements DynamicMock 
{
    public ExpectationCounter addCalls = new ExpectationCounter("add #calls");
    public ExpectationValue addInvokable = new ExpectationValue("add invokable");

    public void add(Invokable invokable) {
        assertNotNull("invokable", invokable);
        addInvokable.setActual(invokable);
        addCalls.inc();
    }
    
    public ExpectationCounter getDefaultStubCalls = new ExpectationCounter("getDefaultStub #calls");
    public Stub getDefaultStubResult;
    public ExpectationValue setDefaultStub = new ExpectationValue("setDefaultStub");
    
    
    public Stub getDefaultStub() {
        getDefaultStubCalls.inc();
        return getDefaultStubResult;
    }
    
    public void setDefaultStub( Stub newDefaultStub ) {
        setDefaultStub.setActual(newDefaultStub);
    }
    
    public Object proxyResult;
    
    public Object proxy() {
        return proxyResult;
    }
    
    public ExpectationCounter resetCalls = new ExpectationCounter("reset #calls");
    
    public void reset() {
    	resetCalls.inc();
    }

    public ExpectationCounter verifyCalls = new ExpectationCounter("verify #calls");

    public void verify() {
        verifyCalls.inc();
    }

    public Object invoke(Object arg0, Method arg1, Object[] arg2)
            throws Throwable {
        return null;
    }
    
    public String toStringResult;

    public String toString() {
        return toStringResult;
    }

    public void verifyExpectations() {
        Verifier.verifyObject(this);
    }
}
