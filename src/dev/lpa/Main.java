package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Integer boxedInt = Integer.valueOf(15);         //preferred but unnecessary.
        Integer deprecatedBoxing = new Integer(15); //deprecated since JDK 9
        int unboxedInt = boxedInt.intValue();             //unnecessary

        //Automatic
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
//        System.out.println(autoUnboxed.getClass().getName());

        //Java is automatically boxing the getLiteralDoublePrimitive return result, because it is assigned to a variable
        //of the java.lang.Double type.
        Double resultBoxed = getLiteralDoublePrimitive();
        //And the same is true below, but in reverse.
        double resultUnboxed = getDoubleObject();

        Integer[] wrapperArray = new Integer[5];
        //The code below autoboxes the primitive integer literal, 50, to an instance of an Integer class.
        wrapperArray[0] = 50;
        //The JVM autoboxed the literal, 50, before assigning it to an element in the array.
        System.out.println(Arrays.toString(wrapperArray));

        System.out.println(wrapperArray[0].getClass().getName());

        //Below we have an anonymous array initializer that sets up an array of the Character wrapper class.
        //The JVM is autoboxing each of the char values below.
        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        //Autoboxing and unboxing is supported within methods themselves; both with method parameters and method
        //return types.

        //Below, if we were to change our method getList to tage a variable amount of Integer wrapper class types (vs.
        //int), our code would still compile, because Java will autobox the numbers passed to the method and return
        //them as Integer types.
        //This means that in a way, we can use primitives and their wrappers interchangeably.
        var ourList = getList(1,2,3,4,5);
        System.out.println(ourList);
    }

    private static ArrayList<Integer> getList(int... varargs){

        ArrayList<Integer> aList = new ArrayList<>();
        for(int i : varargs){
            aList.add(i);
        }
        return aList;
    }

    //The method below unboxes the i argument variable and returns it as an int.
    private static int returnAnInt(Integer i){
        return i;
    }

    //The method below takes an argument as int type and boxes it, then returns it as Integer type.
    private static Integer returnAnInteger(int i){

        return i;

    }
    private static Double getDoubleObject(){

        return Double.valueOf(100.00);

    }

    private static double getLiteralDoublePrimitive(){

        return 100.0;

    }
}

//Why does Java have primitive data types?

//Some object-oriented languages don't support any primitive data types at all, meaning everything is an object.

//But most of the more popular object-oriented languages of the day, support both primitive types and objects, as does
//Java.

//Primitive types generally represent the way data is stored on an operating system.

//Primitives have some advantages over objects, especially as the magnitude, or number of elements increase.

//Objects take up additional memory, and may require a bit more processing power.

//We know we can create objects, with primitive data types as field types, for example, and we can also return primitive
//types from methods, so we can mix and match primitives with objects pretty easily.

//But when we look at classes like ArrayList or the LinkedList, these classes don't support primitive data types, as
//the collection type.

//In other words, we can't create a LinkedList using the int primitive type, like below:

//LinkedList<int> myIntegers = new LinkedList<>();

//This means we can't use all the great functions Lists provide with primitive values.

//More importantly, we can't easily use primitives in things like generics.

//But Java gives us wrapper classes for each primitive type.

//And we can go from a primitive to a wrapper, which is called boxing, or a wrapper to a primitive, which is called
//unboxing, with relative ease in Java.

//A primitive is boxed, or wrapped, in a containing class, whose main data is the primitive value.

//Each primitive data type has a wrapper class, which we've seen before.

//Each wrapper type boxes a specific primitive value.

//Each wrapper class has a static overloaded factory method, valueOf(), which takes a primitive and returns an instance
//of the wrapper class.

//The code shown below returns an instance of the java.lang.Integer class to the boxedInt variable, with a value of 15
//in it.

//We can say this code manually boxes a primitive integer:

//Integer boxedInt = Integer.valueOf(15);

//Another way of boxing, which you'll see in older code, is by creating a new instance of the wrapper class using the
//new keyword, and passing the primitive value to the constructor.

//Integer boxedInt = new Integer(15);

//If you try this in IntelliJ with any Java version greater than JDK-9, IntelliJ will tell you this is deprecated code.

//Deprecated Code:

//Deprecated code means it's older, and may not be supported in a future version.

//In other words, you should start looking for an alternate way of doing something if it's been deprecated.

//Autoboxing:

//We rarely have to manually box primitives, because Java supports something called autoboxing.

//We can simply assign a primitive to a wrapper variable, as shown below:

//Integer boxedInt = 15;

//The code above is preferred over manual boxing.

//Underneath the covers, Java is doing the boxing. In other words, an instance of Integer is created and it's value is
//set to 15.

//Allowing Java to autobox is preferred to any other method, because Java will provide the beste mechanism to do it.

//Every wrapper class supports a method to return the primitive value it contains- this is called unboxing.

//In the example seen below, we've autoboxed the integer value 15 to a variable called boxedInteger.

//This gives us an object which is an Integer wrapper class and has a value of 15.

//To unbox this on an Integer class, we can use the intValue method, which returns the boxed value, the primitive int:

//Integer boxedInteger = 15;
//int unboxedInt = boxedInteger.intValue();

//The above method is called manually unboxing, and like boxing, it's unnecessary to manually unbox.

//Automatic unboxing is really just referred to as unboxing in most cases.

//We can assign an instance of a wrapper class directly to a primitive variable.

//The code below shows an example:

//Integer boxedInteger = 15;
//int unboxedInt = boxedInteger;

//We're assigning an object instance to a primitive variable in the second statement.

//This is allowed, because the object instance is an Integer wrapper, and we're assigning it to an int primitive type
//variable.

//This is the preferred way to unbox a wrapper instance.