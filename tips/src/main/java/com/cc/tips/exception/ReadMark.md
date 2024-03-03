## 异常的最终父类为Throwable类 它下面有两个子类  
                  Throwable
                      |
                    
    Error(jvm级别异常)     Exception(程序异常)
          |                    |
       没有子类       RunTimeException.......    

1、throws 是在方法体后{}前引用的，意思将方法体的异常交给调用方法的调用放处理  
--------------------------
例子：

public void main(){
testException();//如果myException方法体内存在异常，异常返回给main方法处理。
}

public void testException() throws Exception {
  //todo something
}


## 2、throw是用来手动抛出异常的，可以自己自定义异常
例子：
//自定义异常继承Exception或其子类都行  
public class MyException extends Exception{

public MyException(String message){
super(message);//调用父类的构造方法处理异常信息
}

}  
//抛出异常展示  
public void main(){
 throw new MyException("自己定义抛出异常 ！");
}
