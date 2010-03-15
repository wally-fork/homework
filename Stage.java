// main class
public class Stage {
    
    static void DM(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    static void status() {
        Machine machine = Machine.getInstance();
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " +
                           "p: " + machine.getPinguinos() +
                           " | g: " + machine.getGansitos() +
                           " | c: " + machine.getChocoRoles()
                           );
    }

    private static class PinguinosBuyer implements Runnable {
        public void run() {
            Machine machine =  Machine.getInstance();
            Pinguinos pinguinos = new Pinguinos();
            boolean parent_almost_empty = true;
            try {
                while (parent_almost_empty) {
                    machine.sync();
                    pinguinos.buy();
                    status();
                    Thread.sleep(500); // deberia de esperar random
                    if (machine.getGansitos() == 1) {
                        parent_almost_empty = false;
                    }

                }
            } catch (InterruptedException e){}
        }
    }

    private static class GansitosBuyer implements Runnable {
        public void run() {
            Machine machine =  Machine.getInstance();
            Gansitos gansitos = new Gansitos();
            boolean parent_almost_empty = true;
            try {
                while (parent_almost_empty) {
                    machine.sync();
                    gansitos.buy();
                    status();
                    Thread.sleep(200); // deberia de esperar random
                    if (machine.getChocoRoles() == 1) {
                        parent_almost_empty = false;
                    }

                }
            } catch (InterruptedException e){}
        }
    }

    private static class ChocoRolesBuyer implements Runnable {
        public void run() {
            Machine machine = Machine.getInstance();
            ChocoRoles chocoroles = new ChocoRoles(15);
            boolean parent_almost_empty = true;
            try {
                while (parent_almost_empty) {
                    machine.sync();
                    chocoroles.buy();
                    status();
                    Thread.sleep(400); // deberia de esperar random
                    if (machine.getChocoRoles() == 1) {
                        parent_almost_empty = false;
                    }
                }
            } catch (InterruptedException e) { }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Se define un singleton en donde estan definidos cuantos
        // pinguinos, gansitos, chocoroles hay en determinado momento
	// el singleton esta encargado de hacer la sincronizacion tambien
	// para que no existan estados incorrectos e.g. gansitos > chocoroles
        Machine machine = Machine.getInstance();
        long patience = 50 * 60 * 60;
        machine.setPinguinos(5);
        machine.setGansitos(10);
        machine.setChocoRoles(15);
        DM ("Iniciamos!!!");

        Thread t1 = new Thread(new PinguinosBuyer());
        Thread t2 = new Thread(new GansitosBuyer());
        Thread t3 = new Thread(new ChocoRolesBuyer());
        t1.start(); t2.start(); t3.start();

        // Solo les espero 5 segundos
        Thread.sleep(5000);
        DM ("ya se acabo esto por fin? ");
        t1.join(1000);
        t2.join(1000);
        t3.join(1000);

        DM ("Acabamos!!!");
    }
}
