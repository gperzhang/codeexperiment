package pattern.prototype;

public class Client {
    private ConcretePrototypeA concretePrototypeA;
    public Client(ConcretePrototypeA concretePrototypeA){
        this.concretePrototypeA = concretePrototypeA;
    }

    public Prototype startClone(){
        Prototype clone = concretePrototypeA.clone();
        return clone;
    }
}
