package Test;

import model.Model;
import model.Polynomial;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Polynomial p1;
    private Polynomial p2;
    private String operation;
    private Model m;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        p1 =new Polynomial("");
        p2 =new Polynomial("");
        operation= new String();
        m= new Model();

        System.out.println("Set up");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println(operation+" Tear down");
    }

    @org.junit.jupiter.api.Test
    void add() {
       p1 =new Polynomial("2x^3+5x^4+2x");
       p2 =new Polynomial("5x^4+2x");
        Polynomial pResult=new Polynomial("");
        pResult=m.add(p1,p2);
        operation="add";
       assertTrue(pResult.toString().equals("+10x^4+2x^3+4x"));


    }

    @org.junit.jupiter.api.Test
    void subtract() {
        p1 =new Polynomial("3x^3+5x^4+2x");
        p2 =new Polynomial("5x^4+3x^3+1");
        Polynomial pResult=new Polynomial("");
        pResult=m.subtract(p1,p2);
        operation="subtract";
       assertTrue(pResult.toString().equals("+2x-1"));
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        p1 =new Polynomial("2x+5x^2+1");
        p2 =new Polynomial("3x-4x^3");
        Polynomial pResult=new Polynomial("");
        pResult=m.multiply(p1,p2);
        operation="multiply";
        assertTrue(pResult.toString().equals("-20x^5-8x^4+11x^3+6x^2+3x"));
    }

    @org.junit.jupiter.api.Test
    void derive() {
        p1 =new Polynomial("2x+5x^2+1");
        Polynomial pResult=new Polynomial("");
        pResult=m.derive(p1);
        operation="derive";
        assertTrue(pResult.toString().equals("+10x+2"));
    }

    @org.junit.jupiter.api.Test
    void devide() {
        p1 =new Polynomial("1x^3-2x^2+6x-5");
        p2 =new Polynomial("1x^2-1");
        Polynomial pResult=new Polynomial("");
        ArrayList<Polynomial> result= new ArrayList<Polynomial>();
        result=m.devide(p1,p2);
        operation="devide";

        assertTrue((result.get(0).toStringDouble()+" rest "+result.get(1).toStringDouble()).equals("+1.0x-2.0 rest +7.0x-7.0"));
    }

    @org.junit.jupiter.api.Test
    void integrate() {
        p1 =new Polynomial("6x^2-5x+100");
        operation="integrate";

        assertTrue(m.integrate1(p1).toStringDouble().equals("+2.0x^3-2.5x^2+100.0x"));
    }
}