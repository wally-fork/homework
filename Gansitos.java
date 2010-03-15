public class Gansitos {

    Gansitos (){}

    public void fill () {
        // tengo que saber cuantos
        // gansitos hay en ese momento
        Machine machine = Machine.getInstance();
        int chocoroles = machine.getChocoRoles() - 1;
        machine.setGansitos(chocoroles);
    }

    public void buy() {
        Machine machine = Machine.getInstance();
        int gansitos = machine.getGansitos();

        if (gansitos != 0){
            fill();
            System.out.println("gansitos llenos: " +
                               machine.getGansitos()
                               );
        } else {
            machine.setGansitos(gansitos - 1);
        }

        // System.out.println("pinguinos: " + machine.getPinguinos() +
        //                    ", gansitos:  " + machine.getGansitos() +
        //                    ", chocoroles:  " + machine.getChocoRoles()
        //                    );
    }

    public int how_many(){
        Machine machine = Machine.getInstance();
        return machine.getGansitos();
    }

}