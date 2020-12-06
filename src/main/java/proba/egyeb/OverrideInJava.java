package proba.egyeb;

class ParentReturnValue
{

}

class ChildReturnValue extends ParentReturnValue
{

}

class Parent
{
  public ParentReturnValue foo() { return new ParentReturnValue(); }
}

class Child extends Parent
{
  @Override
  public ChildReturnValue foo() { return new ChildReturnValue(); }
}   // pt++ : a visszateresi tipusnal eleh, ha a leszarmazottja, nem kell 1:1 egyezes

public class OverrideInJava
{
}
