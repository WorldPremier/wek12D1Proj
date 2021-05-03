package com.tts;

public class BadThreads {



    static String message;



    private static class CorrectorThread

            extends Thread {



        public void run() {

            try {

                sleep(1000);

            } catch (InterruptedException e) {}

            // Key statement 1:

            message = "Mares do eat oats.";

        }

    }



    public static void main(String args[])

            throws InterruptedException {



        (new CorrectorThread()).start();

        message = "Mares do not eat oats.";

        Thread.sleep(2000);

        // Key statement 2:

        System.out.println(message);

    }

}
//2. The application should print out "Mares do eat oats."
//
//        - Is it guaranteed to always do this? no.
//        Because there is no happens before relationship execution.
//
//        - If not, why not? It will not execute if its running deadlock
//        where one side of the code is waiting for the other to execute
//        hence it will not execute.
//
//
//
//        3. Would it help to change the parameters of the two invocations of Sleep?
//        yes it would. Can help but it cannot guarantee the execution.
//
//
//
//        4. How would you guarantee that all changes to message will be visible in the main thread?
//        To guarantee that you must include all your code under the first executed code.
//        invoke .join() method or create a new synchronization method.