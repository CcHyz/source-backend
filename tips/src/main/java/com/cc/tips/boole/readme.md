在java中字段命名不要以is开头，不论自动类型，如String,boolean,int  
例子：
isTest 的get,set 是会优化掉is的  
istest 的get,set 不会优化掉is  
所以如果要用is开头后面则不要驼峰
