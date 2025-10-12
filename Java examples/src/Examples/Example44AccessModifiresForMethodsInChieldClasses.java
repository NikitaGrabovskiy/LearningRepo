package Examples;

public class Example44AccessModifiresForMethodsInChieldClasses {



}


class Shape {

    public void testPublic(){

    }

    protected void testProtected(){

    }

    void testDefault(){}

    private void testPrivate(){}

}

class Circle extends Shape {

    // PUBLIC CANNOT BE CHANGED
    @Override
    public void testPublic(){

    }

    @Override
    public void testProtected(){

    }

    @Override
    public void testDefault(){

    }

    // Cannot be done
/*    @Override
    public void testPrivate(){

    }*/


}