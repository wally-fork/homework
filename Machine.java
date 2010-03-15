// singleton class
public class Machine {
    private static Machine machine = null;
    protected Machine() {}

    public static int pinguinos;
    public static int gansitos;
    public static int chocoroles;

    public static Machine getInstance() {
        if(machine == null) {
            machine = new Machine();
        }
        return machine;
    }

    public void sync() {
        if (this.pinguinos >= this.gansitos) {

            if (this.gansitos == 0) {
		this.pinguinos = 0;
            } else {
                this.pinguinos = this.gansitos - 1;
            }
	    System.out.println("Sync!");
        }
        if (this.gansitos >= this.chocoroles) {
            if (this.chocoroles == 0) {
		this.gansitos = 0;
	    } else {
		this.gansitos = this.chocoroles - 1;
	    }
            System.out.println("Sync!");
        }
    }

    public void setPinguinos(int _x){
        this.pinguinos = _x;
    }

    public void setGansitos(int _x){
        this.gansitos = _x;
    }

    public void setChocoRoles(int _x){
        this.chocoroles = _x;
    }

    public int getPinguinos(){
        return this.pinguinos;
    }

    public int getGansitos(){
        return this.gansitos;
    }

    public int getChocoRoles(){
        return this.chocoroles;
    }

}