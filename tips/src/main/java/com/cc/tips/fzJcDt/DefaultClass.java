package com.cc.tips.fzJcDt;


 class DefaultClass {
  String a;

  public String b;

  private String c;

  protected  String d;

  protected void protectedMethod(){
   System.out.println("同包子类访问方法!");
  }

  public void publicMethod(){
   System.out.println("全项目访问方法!");
  }

   void defaultMethod(){
   System.out.println("同包访问方法!");
  }

  private void privateMethod(){
   System.out.println("本类访问方法!");
  }



}
