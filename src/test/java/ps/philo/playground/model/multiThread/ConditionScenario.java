package ps.philo.playground.model.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * philo
 *
 * 编写一个Java应用程序，要求有三个进程：student1，student2，teacher，其中线程student1准备“睡”1分钟后再开始上课，线程student2准备“睡”5分钟后再开始上课。Teacher在输出4句“上课”后，“唤醒”了休眠的线程student1；线程student1被“唤醒”后，负责再“唤醒”休眠的线程student2.
 *
 * 作者：微笑面对生活
 * 链接：https://juejin.im/post/5b825a026fb9a019b66e3484
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * # 4/14/19
 */
public class ConditionScenario {
	private int signal = 0;
	public Lock lock = new ReentrantLock();
	Condition teacher = lock.newCondition();
	Condition student1 = lock.newCondition();
	Condition student2 = lock.newCondition();

	public void teacher(){
		lock.lock();
		while (signal != 0){
			try {
				teacher.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("老师叫上课");
		signal++;
		student1.signal();
		lock.unlock();
	}
	public void student1(){
		lock.lock();
		while (signal != 1){
			try {
				student1.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("学生1醒了,准备叫醒学生2");
		signal++;
		student2.signal();
		lock.unlock();
	}
	public void student2(){
		lock.lock();
		while (signal != 2){
			try {
				student2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("学生2醒了");
		signal=0;
		teacher.signal();
		lock.unlock();
	}

	public static void main(String[] args) {
		ConditionScenario ten = new ConditionScenario();
		new Thread(() -> ten.teacher()).start();
		new Thread(() -> ten.student1()).start();
		new Thread(() -> ten.student2()).start();
	}
}
