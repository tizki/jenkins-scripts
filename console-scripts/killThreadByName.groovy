/**
 * Taken from https://stackoverflow.com/a/26306081/947784
 * interrupts a thread by name
 *
 */
Thread.getAllStackTraces().keySet().each() {
    t -> if (t.getName()=="YOUR THREAD NAME" ) {   t.interrupt();  }
}
