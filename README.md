# Concurrency

**Performance Issues With Concurrency**

  Concurrency in Java can introduce a variety of issues related to performance, if not dealt
with carefully. One of these issues is lock contention, which occurs when multiple threads
contend for shared resources. This leads to performance degradation due to increased context
switching and synchronization overhead. There are two main ways to lessen the frequency of
lock contention; reducing the time during which the lock is owned when taken or reducing the
scope of the lock (IBM, 2021). Reducing the scope of the lock is almost always beneficial and
we should only lock what is absolutely necessary.

  Another common challenge associated with concurrency in Java is the introduction of a
deadlock or livelock. A deadlock occurs when threads are blocked indefinitely while waiting for
resources that are held by other threads, normally resulting in the program crashing. An example
of a deadlock can be seen in the following program:

![image](https://github.com/Sopherior/Concurrency/assets/68802489/0e00d67e-8f89-4c89-8a8b-b56a1c34f633)

  Livelocks occur when threads keep repeating the same action without actually
progressing. These can also lead to crashes and severely hinder performance. To avoid a
deadlock, we should avoid multiple locks being acquired by the same thread (Kumar, 2020). If
we can’t avoid this, then the locks must be acquired in the same order. Avoiding a livelock
depends on the specific situation, but, for example, if two threads are repeatedly acquiring and
releasing a lock, we could modify the code so that locks are acquired at random intervals.

  Other performance issues pertaining to concurrency include thread coordination
problems, thread starvation, and priority inversion. Thread coordination can introduce
performance challenges if we use too many thread synchronization mechanisms such as locks or
semaphores. Thread starvation occurs when a thread is unable to obtain the necessary resources
to make progress due to scheduling or priority issues, resulting in a lower level of program
responsiveness. This issue can be aided by using thread.sleep() and thread.yield() so other
threads have a chance to execute.

  Priority inversion occurs when a low-priority thread holds a resource that a
higher-priority thread needs. This shows the importance of properly prioritizing tasks.
Additionally, be careful not to create or destroy too many threads and use a thread pool if
needed. Finally, follow proper resource management practices so oversubscription does not
occur. Oversubscription is when there are more threads than processing resources available,
leading to contention and inefficient use of resources.

**String Vulnerabilities**
  In Java, string vulnerabilities typically involve improper handling or manipulation of
strings, which can lead to security vulnerabilities such as injection attacks, buffer overflows, or
unintended information disclosure. A buffer overflow occurs when the length of a string exceeds
the allocated buffer size. In Java, this isn’t too much of a concern because there are automatic
bounds checking, but it’s still something to be mindful of. To mitigate buffer-related
vulnerabilities, it’s important to ensure proper memory management, efficient string
manipulation techniques, and use appropriate data structures to handle strings effectively.
  
  String injection is another common vulnerability and this occurs when untrusted user
input is concatenated directly into SQL queries, system commands, or other dynamically
generated strings. Code that may lead to string injection may look something like this:

![image](https://github.com/Sopherior/Concurrency/assets/68802489/e540b390-19ea-426e-a3c7-7f90408bb997)

  To ensure this does not happen, it is crucial to ensure that user input is validated,
sanitized, and parameterized. Additionally, if these measures are not implemented, cross-site
scripting may occur which is when an attacker injects malicious scripts that are executed in the
context of other users' browsers, potentially leading to unauthorized actions or information theft.

**Security of Data Types**

  My Java concurrency program uses a variety of different data types, including “Lock,”
“ReentrantLock,” “boolean,” “Thread,” “System.out.println(),” “String,” and “int.” First, I will
discuss the “Lock” and “ReentrantLock” data types. Neither of these data types poses any
security risks in and of themselves. However, it's important to consider the overall security of the
code that uses these synchronization mechanisms. For example, if the code within the critical
section (between lock() and unlock()) deals with sensitive data, it should be handled securely to
prevent unauthorized access or leakage.
  
  The “boolean” data type represents a true or false value and is secure but the use of
boolean variables in a multi-threaded environment should be carefully synchronized to ensure
proper visibility and consistency. The “Thread” data type is secure as well, as long as you are
careful when implementing threads and ensure that you manage them properly. The
System.out.println() method also does not introduce any specific security vulnerabilities.
However, when printing sensitive information it is important to ensure that proper precautions
are taken to prevent unintended information disclosure.

  Finally, there are the “String” and “int” data types. Strings themselves do not present any
security issues, but if used incorrectly they can, as discussed in the previous section. If the “int”
data type is used improperly, there are a few potential issues. For example, integer overflow or
underflow may occur if the integer is greater than or less than the maximum or minimum value
(Poston, 2021). In addition, an off-by-one error could have occurred if the limits to the for loop
were not set correctly. Finally, if integer values are shared and modified across multiple threads
concurrently, proper synchronization mechanisms need to be implemented to prevent data races.

**References**
IBM. (2021, March 3). Resolving lock contention. Www.ibm.com.
https://www.ibm.com/docs/en/mon-diag-tools?topic=perspective-resolving-lock-contenti
on
Kumar, K. (2020, April 9). Java Thread Deadlock and Livelock. Baeldung.
https://www.baeldung.com/java-deadlock-livelock
Poston, H. (2021, March 31). Integer overflow and underflow vulnerabilities. Infosec Resources.
https://resources.infosecinstitute.com/topic/integer-overflow-and-underflow-vulnerabiliti
es/#:~:text=Integer%20overflow%20vulnerabilities%20are%20caused
