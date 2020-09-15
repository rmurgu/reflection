package org.tutorial;

@Marked
public class Parent {

    private String privateParentField;
    public String publicParentField;

    public String getPrivateParentField() {
        return privateParentField;
    }

    public void setPrivateParentField(String privateParentField) {
        this.privateParentField = privateParentField;
    }

    public String getPublicParentField() {
        return publicParentField;
    }

    public void setPublicParentField(String publicParentField) {
        this.publicParentField = publicParentField;
    }

    private void privateParentMethod() {

    }

    protected void protectedParentMethod() {

    }

}
