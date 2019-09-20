package ExecutorTest;

class Task implements Runnable {
    
    String taskname;
    public Task(String name)
    {
    taskname = name;
    }
      public void run() 
{
            System.out.println("The task name is " +taskname +" executed by " +Thread.currentThread().getName());
    }
}
