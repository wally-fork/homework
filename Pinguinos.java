public class Pinguinos {

    Pinguinos (){}

    public void fill () {
        Machine machine = Machine.getInstance();
        int gansitos = machine.getGansitos() - 1;
        // System.out.println("los gansitos:" + gansitos);
        machine.setPinguinos(gansitos);
    }

    public void buy() {
        Machine machine = Machine.getInstance();
        int pinguinos = machine.getPinguinos();

        if (pinguinos != 0){
            fill();
            System.out.println("pinguinos llenos:" +
                               machine.getPinguinos()
                               );
        } else {
            machine.setPinguinos(pinguinos - 1);
        }
        // System.out.println("pinguinos: " + machine.getPinguinos() +
        //                    ", gansitos:  " + machine.getGansitos() +
        //                    ", chocoroles:  " + machine.getChocoRoles()
        //                    );

    }
    
    public int how_many(){
        Machine machine = Machine.getInstance();
        return machine.getPinguinos();
    }
}