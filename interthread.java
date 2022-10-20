/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interthread;

/**
 *
 * @author ashwi
 */


class Q
{
    int n;
    boolean valueSet = false;
    synchronized int get()
    {
        while(!valueSet)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Get: " + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n)
    {
        while(valueSet)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("InterruptedExceptioncaught");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}
class Producer implements Runnable
{ Q q;
    Producer(Q q)
    {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run()
    {
        int i = 0;
        while(true)
        {
            if(i==10){
            System.exit(0);
            }
            q.put(i++);
        }
        
    }
}
class Consumer implements Runnable
{
    Q q;
    Consumer(Q q)
    {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    @Override
    public void run()
    {
        while(true)
        {
            q.get();
        }
    } }
public class q2
{
    public static void main(String args[])
    {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}
    
    

