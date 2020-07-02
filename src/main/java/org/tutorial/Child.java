package org.tutorial;

@Marked
public class Child extends Parent implements Locomotion {

    public static final int staticFinalField = 0;
    private final String privateFinal;
    private String privateField;
    public int publicField;

    public Child() {
        privateFinal = "private_final";
    }

    private Child(String test) {
        privateFinal = "private_final";
    }

    public String getPrivateFinal() {
        return privateFinal;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public int getPublicField() {
        return publicField;
    }

    public void setPublicField(int publicField) {
        this.publicField = publicField;
    }

    private String getPrivateFieldPrivateMethod() {
        return privateField;
    }

    protected void protectedChildMethod() {

    }

    public static String staticMethod(String param) {
        return param;
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }
}
