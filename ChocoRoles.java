public class ChocoRoles {

    private int max;
    ChocoRoles (int _quantity){
        Machine machine = Machine.getInstance();
        max = _quantity;
        machine.setChocoRoles(_quantity);
    }

    ChocoRoles (){}

    public void fill () {
        // tengo que saber cuantos
        // chocoroles hay en ese momento
        Machine machine = Machine.getInstance();
        int chocoroles = max;
        machine.setChocoRoles(chocoroles);
    }

    public void buy() {
        Machine machine = Machine.getInstance();
        int chocoroles = machine.getChocoRoles();

        if (chocoroles <= 0){
            fill();
            System.out.println("chocoroles llenos: " +
                               machine.getChocoRoles()
                               );
        } else {
            machine.setChocoRoles(chocoroles - 1);
        }
        // System.out.println("pinguinos: " + machine.getPinguinos() +
        //                    ", gansitos:  " + machine.getGansitos() +
        //                    ", chocoroles:  " + machine.getChocoRoles()
        //                    );

    }

    public int how_many(){
        Machine machine = Machine.getInstance();
        return machine.getChocoRoles();
    }
}
