### 注意：使用Kubelet describe 查看日志，一定要带上 命名空间，否则会报如下错误
k8s层级:  
namespace->pods->pod(可以存在多个namespeace，一个namespeace下有多个pods,pod则是最小工作单元)   
***
**注意:  
1、jenkins-5bdc5bf9c6-76bsn是pod名字。  
2、devops-tools指的是namespace**  

查看k8s nameSpaces:  
kubectl get namespaces  

查看k8s集群中所有的pods:  
kubectl get pods -A  

查看一个namespace下pods列表  
kubectl get pods -n devops-tools **(devops-tools指的是namespace)** 

获取一个pod的详细信息   
kubectl describe pod jenkins-5bdc5bf9c6-76bsn -n devops-tools    

查看对应pod的日志:  
kubectl logs -f jenkins-5bdc5bf9c6-76bsn -n devops-tools

进入一个pod容器内:  
kubectl exec -it jenkins-5bdc5bf9c6-76bsn -n devops-tools /bin/sh  

查看所有pod,namespace信息:
kubectl get all --all-namespaces